package org.conan.fans.service.impl;

import java.io.IOException;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboCloudService;
import org.springframework.beans.factory.annotation.Autowired;

import weibo4j.model.WeiboException;

public class WeiboCloudServiceImpl extends WeiboServiceImpl implements WeiboCloudService {
    
    @Autowired
    WeiboActionService weiboActionService;
    
    @Override
    public void sendFansCloud(long uid) throws IOException, WeiboException {
        String msg = "我的粉丝云";
        String image = "/home/conan/app/weibo-apps/fans/R/image/cloud/" + uid + ".png";
        weiboActionService.send(msg, image);
    }
    
}
