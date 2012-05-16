package org.conan.fans.service;

import weibo4j.model.WeiboException;


public interface WeiboInitService extends WeiboService {

    void initAPI();
    void initUid(long uid);
    void setToken(String token, long uid, String expireIn, String state)throws WeiboException;

}
