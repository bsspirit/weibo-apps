package org.conan;

import org.conan.fans.service.WeiboInitService;
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

    // accessToken=2.00v9eSLCQ6BahBff832078d6qDa9sC, expireIn=86400, refreshToken=,uid=1999250817]
    public static void main(String[] args) throws WeiboException {
        // WeiboFansService weiboFansService=(WeiboFansService)SpringInitialize.getContext().getBean(WeiboFansService.class);
        // weiboFansService.fansAction();
        // weiboFansService.fansIDsAction();
        // WeiboActionService WeiboActionService=(WeiboActionService)SpringInitialize.getContext().getBean(WeiboActionService.class);
        // WeiboActionService.send("测试API。。。");
        
        WeiboInitService service = SpringInitialize.getContext().getBean(WeiboInitService.class);
        service.setToken("2.00v9eSLCQ6BahBff832078d6qDa9sC", 2745820824l, "86400", null);
    }

}
