package org.conan.fans.service;

import org.conan.base.service.SpringService;

import weibo4j.model.WeiboException;

public interface WeiboFansService extends SpringService {

    void fansAction() throws WeiboException;
    void fansIDsAction() throws WeiboException;

}
