package org.conan.fans.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.conan.base.service.SpringServiceImpl;
import org.conan.fans.service.WeiboService;
import org.conan.fans.system.model.ConfigDTO;
import org.conan.fans.system.service.ConfigService;
import org.conan.fans.weibo.model.AccountDTO;
import org.conan.fans.weibo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.Weibo;

@Service
public class WeiboServiceImpl extends SpringServiceImpl implements WeiboService {

    @Autowired
    AccountService accountService;

    @Override
    public void setUid(long uid) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", uid);
        AccountDTO dto = accountService.getAccountOne(paramMap);

        Weibo weibo = new Weibo();
        weibo.setToken(dto.getToken());
    }


}
