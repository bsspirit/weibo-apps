package org.conan.fans.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.conan.base.service.SpringService;
import org.conan.base.service.SpringServiceImpl;
import org.conan.base.util.MyDate;
import org.conan.fans.service.WeiboCheckService;
import org.conan.fans.system.model.ApplyUserDTO;
import org.conan.fans.system.model.LimitUserDTO;
import org.conan.fans.system.service.ApplyUserService;
import org.conan.fans.system.service.LimitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeiboCheckServiceImpl extends SpringServiceImpl implements WeiboCheckService {
    
    @Autowired
    LimitUserService limitUserService;
    @Autowired
    ApplyUserService applyUserService;
    
    /**
     * 　true:允许, false:不允许
     */
    public boolean limitCheck(long uid, String name) {
        boolean valid = false;
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", uid);
        paramMap.put("name", name);
        LimitUserDTO dto = limitUserService.getLimitUserOne(paramMap);
        
        if (dto == null) {
            dto = new LimitUserDTO(uid, name, SpringService.TIME_DAY, null);
            limitUserService.insertLimitUser(dto);
            return true;
        } else {
            // 当前时间-创建时间>有效期(True),允许访问
            Date now = MyDate.getNow();
            if (MyDate.diffSecs(now, MyDate.timestampDate(dto.getCreate_date())) > dto.getLimit_time()) {
                valid = true;
                dto.setCreate_date(new Timestamp(now.getTime()));
                limitUserService.updateLimitUser(dto);
            }
        }
        return valid;
    }
    
    /**
     * 0:第一次，未生成,1:已生成，未过期,2:已生成，已过期
     */
    public int limitLoadCheck(long uid, String name) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", uid);
        paramMap.put("name", name);
        LimitUserDTO dto = limitUserService.getLimitUserOne(paramMap);
        if (dto == null) {
            return 0;
        } else {// 当前时间-创建时间>有效期(True),允许访问
            if (MyDate.diffSecs(MyDate.getNow(), MyDate.timestampDate(dto.getCreate_date())) > dto.getLimit_time()) {
                return 2;
            }
        }
        return 1;
    }
    
    public int applyCheck(long uid, String name) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", uid);
        paramMap.put("name", name);
        ApplyUserDTO dto = applyUserService.getApplyUserOne(paramMap);
        if (dto == null) {
            return 0;
        }
        return 1;
    }
    
}
