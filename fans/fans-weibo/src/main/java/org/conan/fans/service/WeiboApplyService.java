package org.conan.fans.service;

import java.io.IOException;

import org.conan.base.service.SpringService;

import weibo4j.model.WeiboException;

public interface WeiboApplyService extends SpringService {
    
    void apply(Long uid, String type);
    void callback(Long uid, String screen, String type)throws WeiboException, IOException;
}
