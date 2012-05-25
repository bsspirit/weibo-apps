package org.conan.fans.service;

import org.conan.fans.weibo.model.AccountDTO;

import weibo4j.model.WeiboException;


public interface WeiboInitService extends WeiboService {

    AccountDTO initAPI(String code, String state) throws WeiboException; 
    AccountDTO setToken(String token, long uid, String expireIn, String state)throws WeiboException;
    void initUid(long uid);

}
