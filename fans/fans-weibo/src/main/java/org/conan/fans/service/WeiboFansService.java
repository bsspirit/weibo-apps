package org.conan.fans.service;

import weibo4j.model.WeiboException;

public interface WeiboFansService extends WeiboService {

    void fansAction() throws WeiboException;
    void fansIDsAction() throws WeiboException;

}
