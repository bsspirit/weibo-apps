package org.conan.fans.service;

import org.conan.base.service.SpringService;

public interface WeiboCheckService extends SpringService {
    
    boolean limitCheck(long uid, String name);
    int limitLoadCheck(long uid, String name);
}
