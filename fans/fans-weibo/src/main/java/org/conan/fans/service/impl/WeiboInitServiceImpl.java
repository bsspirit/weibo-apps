package org.conan.fans.service.impl;

import javax.annotation.PostConstruct;

import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.util.WeiboToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.Weibo;

@Service
public class WeiboInitServiceImpl extends WeiboServiceImpl implements WeiboInitService {
    
    @Autowired
    WeiboToken weiboToken;
    
    @PostConstruct
    public void initAPI() {
        Weibo weibo = new Weibo();
        weibo.setToken(weiboToken.getToken());
    }
    
}
