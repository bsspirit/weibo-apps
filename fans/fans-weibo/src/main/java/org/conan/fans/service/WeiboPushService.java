package org.conan.fans.service;

import java.io.IOException;

import weibo4j.model.WeiboException;

/**
 * 微博抓数据
 * 
 * @author Conan
 * 
 */
public interface WeiboPushService extends WeiboService {
    
    // weibo
    void send(long uid, String msg) throws WeiboException;
    void send(long uid, String msg, String image) throws WeiboException, IOException;
    
    // follow
    void follow(long uid, long fid) throws WeiboException;
    void follow(long uid, String fscreen) throws WeiboException;
    
}
