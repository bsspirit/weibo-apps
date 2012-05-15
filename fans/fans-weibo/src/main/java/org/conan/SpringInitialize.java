package org.conan;

import org.conan.fans.service.WeiboActionService;
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

    public static void main(String[] args) throws WeiboException {
        // WeiboFansService weiboFansService=(WeiboFansService)SpringInitialize.getContext().getBean(WeiboFansService.class);
        // weiboFansService.fansAction();
        // weiboFansService.fansIDsAction();
        
        WeiboActionService WeiboActionService=(WeiboActionService)SpringInitialize.getContext().getBean(WeiboActionService.class);
        WeiboActionService.send("测试API。。。");
    }

}
