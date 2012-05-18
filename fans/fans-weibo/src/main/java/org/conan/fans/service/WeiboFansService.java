package org.conan.fans.service;

import weibo4j.model.WeiboException;

public interface WeiboFansService extends WeiboService {

    void fans(long uid) throws WeiboException;
    void fansIDs(long uid) throws WeiboException;
    void bifansIDs(long uid) throws WeiboException;

}
