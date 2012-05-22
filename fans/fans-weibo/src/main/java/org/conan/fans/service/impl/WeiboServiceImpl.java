package org.conan.fans.service.impl;

import org.conan.base.service.SpringServiceImpl;
import org.conan.fans.service.WeiboService;
import org.conan.fans.service.util.TokenMap;
import org.springframework.stereotype.Service;

@Service
public class WeiboServiceImpl extends SpringServiceImpl implements WeiboService {
    
    @Override
    public void setUid(long uid) {
        TokenMap.initToken(uid);
    }
    
}
