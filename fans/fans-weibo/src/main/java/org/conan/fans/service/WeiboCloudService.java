package org.conan.fans.service;

import java.io.IOException;

import weibo4j.model.WeiboException;

/**
 * 微博云
 * 
 * @author conan
 * 
 */
public interface WeiboCloudService extends WeiboService {
    
    void sendFansCloud(long uid) throws IOException, WeiboException;
    
}
