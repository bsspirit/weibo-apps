//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.fans.system.dao.LimitUserDAO;
import org.conan.fans.system.service.LimitUserService;
import org.conan.fans.system.model.LimitUserDTO;

/**
 * This is LimitUser Service implemention
 * @author Conan Zhang
 * @date 2012-05-31
 */
@Service(value="limitUserService")
public class LimitUserServiceImpl extends SpringServiceImpl implements LimitUserService {

    @Autowired
    LimitUserDAO limitUserDAO;

    public int insertLimitUser(LimitUserDTO dto) {
        return limitUserDAO.insertLimitUser(dto);
    }
    
    public int updateLimitUser(LimitUserDTO dto) {
        return limitUserDAO.updateLimitUser(dto);
    }
    
    public int saveLimitUser(LimitUserDTO dto) {
        if (dto.getId() > 0) {
            return updateLimitUser(dto);
        }
        return insertLimitUser(dto);
    }

    public int saveLimitUser(LimitUserDTO dto, Map<String, Object> paramMap) {
        LimitUserDTO obj = getLimitUserOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateLimitUser(dto);
        }
         return insertLimitUser(dto);
    }

    public int deleteLimitUser(int id) {
        return limitUserDAO.deleteLimitUser(id);
    }

	public int deleteLimitUser(LimitUserDTO dto) {
        return limitUserDAO.deleteLimitUsers(dto);
    }

    public LimitUserDTO getLimitUserById(int id) {
        return limitUserDAO.getLimitUserById(id);
    }
    
    public LimitUserDTO getLimitUserOne(Map<String, Object> paramMap) {
        return limitUserDAO.getLimitUserOne(paramMap);
    }

    public List<LimitUserDTO> getLimitUsers(Map<String, Object> paramMap) {
        return limitUserDAO.getLimitUsers(paramMap);
    }

    public PageOutObject<LimitUserDTO> getLimitUsersPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<LimitUserDTO> list = limitUserDAO.getLimitUsers(paramMap);
        int count = limitUserDAO.getLimitUsersCount(paramMap);
        return new PageOutObject<LimitUserDTO>(count, list, page);
    }
    
    public int getLimitUsersCount(Map<String, Object> paramMap) {
        return limitUserDAO.getLimitUsersCount(paramMap);
    }

}
