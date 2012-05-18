package org.conan.fans.service;

import weibo4j.model.WeiboException;

public interface WeiboUserService extends WeiboService{
    
    void usersByUids(long[] uids) throws WeiboException;
    
}
