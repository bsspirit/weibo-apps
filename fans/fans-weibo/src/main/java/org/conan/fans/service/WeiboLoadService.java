package org.conan.fans.service;

import weibo4j.model.WeiboException;

/**
 * 微博抓数据
 * 
 * @author Conan
 * 
 */
public interface WeiboLoadService {
    
    //key
    void key(long uid);
    
    //fans
    void fansAll(long uid) throws WeiboException;//include key
    void fans(long uid) throws WeiboException;
    void fansIDs(long uid) throws WeiboException;//update default=FALSE
    void fansIDs(long uid, boolean update) throws WeiboException;
    void bifansIDs(long uid) throws WeiboException;
    void bifansIDs(long uid,boolean update) throws WeiboException;//update default=FALSE
    
    //fans'fans
    void fansFansIDS(long uid)throws WeiboException;//粉丝的粉丝
    
    //user
    void usersByUids(long[] uids) throws WeiboException;
    
}
