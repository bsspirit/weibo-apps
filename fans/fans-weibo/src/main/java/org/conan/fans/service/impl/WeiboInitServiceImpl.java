package org.conan.fans.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.util.TokenMap;
import org.conan.fans.weibo.model.AccountDTO;
import org.conan.fans.weibo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.Weibo;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

@Service
public class WeiboInitServiceImpl extends WeiboServiceImpl implements WeiboInitService {

    @Autowired
    AccountService accountService;

    @Autowired
    WeiboActionService weiboActionService;

    public void initAPI() {

    }

    public void setToken(String token, long uid, String expireIn, String state) throws WeiboException {
        Weibo weibo = new Weibo();
        weibo.setToken(token);
        User user = weiboActionService.user(uid);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", uid);
        AccountDTO dto = new AccountDTO(uid, new Timestamp(System.currentTimeMillis()), expireIn, null, state, user.getScreenName(), token);
        accountService.saveAccount(dto, paramMap);

    }

    public void initUid(long uid) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", uid);
        AccountDTO dto = accountService.getAccountOne(paramMap);
        TokenMap.tokenMaps.put(uid, dto);
    }
}
