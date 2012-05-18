package org.conan;

import java.io.IOException;

import org.conan.fans.service.WeiboFansService;
import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.impl.WeiboFansServiceImpl;
import org.conan.fans.service.impl.WeiboInitServiceImpl;
import org.conan.fans.service.util.TokenMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import weibo4j.model.WeiboException;

public class SpringInitialize {
    
    private static ApplicationContext ctx = null;
    
    private SpringInitialize() {
    }
    
    public static ApplicationContext getContext() {
        if (ctx == null) {
            ctx = new ClassPathXmlApplicationContext("spring.xml");
        }
        return ctx;
    }
    
    // AccessToken [accessToken=2.00v9eSLCzzDJbE2f8c770a4005xZbx, expireIn=86400, refreshToken=,uid=1999250817]
    public static void main(String[] args) throws WeiboException, IOException {
        long uid = 1999250817;
        WeiboInitService service = SpringInitialize.getContext().getBean(WeiboInitServiceImpl.class);
        service.initUid(uid);
        
        TokenMap.initToken(uid);
        WeiboFansService weiboFansService = SpringInitialize.getContext().getBean(WeiboFansServiceImpl.class);
        weiboFansService.fansIDs(2587998071l);
        weiboFansService.fans(2587998071l);
        
        // TokenMap.initToken(uid);
        // WeiboActionService a = SpringInitialize.getContext().getBean(WeiboActionServiceImpl.class);
        // a.send("我的粉丝云", "/home/conan/app/weibo-apps/fans/R/image/cloud/1999250817.png");
        
        // WeiboInitService service = SpringInitialize.getContext().getBean(WeiboInitServiceImpl.class);
        // service.setToken("2.00v9eSLCzzDJbE2f8c770a4005xZbx", 1999250817, "86400", null);
    }
    
}
