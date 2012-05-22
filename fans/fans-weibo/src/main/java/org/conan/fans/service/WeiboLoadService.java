package org.conan.fans.service;

import weibo4j.model.WeiboException;

public interface WeiboLoadService {
    
    //fans
    void fans(long uid) throws WeiboException;
    void fansIDs(long uid) throws WeiboException;
    void bifansIDs(long uid) throws WeiboException;
    
    //user
    void usersByUids(long[] uids, long uid) throws WeiboException;
    
}
