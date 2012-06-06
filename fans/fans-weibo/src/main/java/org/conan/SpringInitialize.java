package org.conan;

import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.WeiboLoadService;
import org.conan.fans.service.impl.WeiboActionServiceImpl;
import org.conan.fans.service.impl.WeiboInitServiceImpl;
import org.conan.fans.service.impl.WeiboLoadServiceImpl;
import org.conan.fans.service.impl.WeiboReportServiceImpl;
import org.conan.fans.weibo.model.ProvincesDTO;
import org.conan.fans.weibo.service.ProvincesService;
import org.conan.r.service.RService;
import org.conan.r.service.RServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import weibo4j.Weibo;
import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

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
    
    // AccessToken [accessToken=2.00v9eSLCzzDJbE558491fdd7f6ZysD, expireIn=86400, refreshToken=,uid=1999250817]
    public static void main(String[] args) throws WeiboException, IOException {
        // ConfigService service = SpringInitialize.getContext().getBean(ConfigService.class);
        // System.out.println(service.getConfigById(1));
        
        // long uid = 1999250817;
        // initUid();
        // demoSend();
        // demoToken();
        // demoR();
        // loadFansId();
        
        // TokenMap.initToken(uid);
        // WeiboFansService weiboFansService = SpringInitialize.getContext().getBean(WeiboFansServiceImpl.class);
        // weiboFansService.fansIDs(1999250817);
        // weiboFansService.fans(1999250817);
        
        // demoToken();
        // rIncrease();
        // geo();
        
        initProvinces();
    }
    
    
    private static void initProvinces() {
        WeiboInitService service = SpringInitialize.getContext().getBean(WeiboInitServiceImpl.class);
        ProvincesService p = SpringInitialize.getContext().getBean(ProvincesService.class);
//        service.initProvinces();
        List<ProvincesDTO> list = p.getProvincess(new HashMap<String, Object>());
        service.initProvincesGeo(list);
    }
    
    private static void geo() throws WeiboException {
        long uid = 1999250817;
        String address = "北京市朝阳区双井";
        WeiboActionService a = SpringInitialize.getContext().getBean(WeiboActionServiceImpl.class);
        a.setUid(uid);
        Object o = a.addressToGeo(address);
        System.out.println(o);
    }
    
    private static void loadFansId() throws WeiboException {
        long uid = 1999250817;
        WeiboLoadService load = SpringInitialize.getContext().getBean(WeiboLoadServiceImpl.class);
        load.fans(uid);
    }
    
    // private static void initUid() {
    // long uid = 1999250817;
    // WeiboInitService service = SpringInitialize.getContext().getBean(WeiboInitServiceImpl.class);
    // service.initUid(uid);
    // }
    
    // array(4) { ["access_token"]=> string(32) "2.00AKoZEDzzDJbE13b95a82e00Bya1R" ["remind_in"]=> string(5) "83613"
    // ["expires_in"]=> int(83613) ["uid"]=> string(10) "2816038140" }
    private static void demoToken() throws WeiboException {
        WeiboInitService service = SpringInitialize.getContext().getBean(WeiboInitServiceImpl.class);
        service.setToken("2.00AKoZEDzzDJbE13b95a82e00Bya1R", 2816038140l, "83613", null);
    }
    
    private static void demoSend() throws WeiboException, IOException {
        long uid = 1999250817;
        WeiboActionService a = SpringInitialize.getContext().getBean(WeiboActionServiceImpl.class);
        a.setUid(uid);
        a.send("我的粉丝在微笑", "../R/image/face/" + uid + ".png");
    }
    
    private static void demoR() {
        long uid = 1999250817;
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", String.valueOf(uid));
        map.put("path", "/home/conan/app/weibo-apps/fans/R/image/v/");
        RService rService = SpringInitialize.getContext().getBean(RServiceImpl.class);
        rService.run("/home/conan/app/weibo-apps/fans/R/fansVerifer.R", map);
    }
    
    private static void rIncrease() {
        long uid = 1999250817;
        WeiboReportServiceImpl report = SpringInitialize.getContext().getBean(WeiboReportServiceImpl.class);
        report.increase(uid);
    }
}
