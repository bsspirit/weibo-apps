package org.conan;

import java.io.IOException;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.impl.WeiboActionServiceImpl;
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
    
    //AccessToken [accessToken=2.00v9eSLCzzDJbE558491fdd7f6ZysD, expireIn=86400, refreshToken=,uid=1999250817]
    public static void main(String[] args) throws WeiboException, IOException {
        long uid = 1999250817;
        WeiboInitService service = SpringInitialize.getContext().getBean(WeiboInitServiceImpl.class);
        service.initUid(uid);
        
//        TokenMap.initToken(uid);
//        WeiboFansService weiboFansService = SpringInitialize.getContext().getBean(WeiboFansServiceImpl.class);
//        weiboFansService.fansIDs(1999250817);
//        weiboFansService.fans(1999250817);
        
         TokenMap.initToken(uid);
         WeiboActionService a = SpringInitialize.getContext().getBean(WeiboActionServiceImpl.class);
         a.send("我的粉丝在微笑", "../R/image/face/"+uid+".png");
        
//         WeiboInitService service = SpringInitialize.getContext().getBean(WeiboInitServiceImpl.class);
//         service.setToken("2.00v9eSLCzzDJbE558491fdd7f6ZysD", 1999250817, "86400", null);
    }
    
}
