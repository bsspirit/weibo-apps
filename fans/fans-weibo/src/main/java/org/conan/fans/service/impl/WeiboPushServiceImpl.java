package org.conan.fans.service.impl;

import java.io.IOException;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.model.WeiboException;

@Service
public class WeiboPushServiceImpl extends WeiboServiceImpl implements WeiboPushService {
    
    @Autowired
    WeiboActionService action;
    
    @Override
    public void send(long uid, String msg) throws WeiboException {
        action.setUid(uid);
        action.send(msg);
    }
    
    @Override
    public void send(long uid, String msg, String image) throws WeiboException, IOException {
        action.setUid(uid);
        action.send(msg, image);
    }
    
    @Override
    public void follow(long uid, long fid) throws WeiboException {
        action.setUid(uid);
        action.follow(fid);
    }
    
    @Override
    public void follow(long uid, String fscreen) throws WeiboException {
        action.setUid(uid);
        action.follow(fscreen);
    }
    
}
