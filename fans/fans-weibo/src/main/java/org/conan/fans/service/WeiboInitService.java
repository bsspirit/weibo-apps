package org.conan.fans.service;

import java.util.List;

import org.conan.fans.weibo.model.AccountDTO;
import org.conan.fans.weibo.model.ProvincesDTO;

import weibo4j.model.WeiboException;

/**
 * API初始化
 * 
 * @author Conan
 * 
 */
public interface WeiboInitService extends WeiboService {

    AccountDTO initAPI(String code, String state) throws WeiboException; 
    AccountDTO setToken(String token, long uid, String expireIn, String state)throws WeiboException;
//    void initUid(long uid);
    
    void initProvinces();
    void initProvincesGeo(List<ProvincesDTO> list);

}
