package org.conan.fans.service.impl;

import java.io.IOException;
import java.text.MessageFormat;

import org.conan.base.service.SpringService;
import org.conan.base.service.SpringServiceImpl;
import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboApplyService;
import org.conan.fans.service.WeiboPushService;
import org.conan.fans.service.WeiboReportService;
import org.conan.fans.system.model.ApplyUserDTO;
import org.conan.fans.system.model.ConfigDTO;
import org.conan.fans.system.model.LimitUserDTO;
import org.conan.fans.system.service.ApplyUserService;
import org.conan.fans.system.service.ConfigService;
import org.conan.fans.system.service.LimitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.model.WeiboException;

@Service
public class WeiboApplyServiceImpl extends SpringServiceImpl implements WeiboApplyService {
    
    @Autowired
    ApplyUserService applyUserService;
    @Autowired
    LimitUserService limitUserService;
    @Autowired
    WeiboActionService weiboActionService;
    @Autowired
    WeiboReportService report;
    @Autowired
    WeiboPushService push;
    @Autowired
    ConfigService configService;
    
    @Override
    public void apply(Long uid, String type) {
        applyUserService.insertApplyUser(new ApplyUserDTO(uid, type, null));
    }
    
    @Override
    public void callback(Long uid, String screen, String type) throws WeiboException, IOException {
        if (type.equals(SpringService.APPLY_WEIBO_SOCIAL)) { // R渲染图片
            report.socialName(uid);
            report.socialNode(uid);
            
            // 插入limit
            LimitUserDTO dto = new LimitUserDTO(uid, SpringService.LIMIT_WEIBO_LOAD_SOCIAL, SpringService.TIME_QUARTER, null);
            limitUserService.insertLimitUser(dto);
            
            weiboActionService.setUid(SpringService.OFFICIAL_UID);
            
            // 发微通知用户
            ConfigDTO config = configService.config(SpringService.REST_SOCIAL_NAME);
            StringBuilder sb = new StringBuilder();
            sb.append("@" + screen);
            sb.append(" ,我们已经为您生成了,");
            sb.append(config.getTemplate());
            push.send(uid, sb.toString(), MessageFormat.format(config.getOutput(), String.valueOf(uid)));
            
            config = configService.config(SpringService.REST_SOCIAL_NODE);
            sb = new StringBuilder();
            sb.append("@" + screen);
            sb.append(" ,我们已经为您生成了,");
            sb.append(config.getTemplate());
            push.send(uid, sb.toString(), MessageFormat.format(config.getOutput(), String.valueOf(uid)));
        }
    }
    
}
