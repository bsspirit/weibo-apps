package org.conan.fans.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.conan.api.map.GoogleMap;
import org.conan.api.map.SinaProvinces;
import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.util.TokenMap;
import org.conan.fans.service.util.WeiboTransfer;
import org.conan.fans.weibo.model.AccountDTO;
import org.conan.fans.weibo.model.ProvincesDTO;
import org.conan.fans.weibo.model.UserDTO;
import org.conan.fans.weibo.service.AccountService;
import org.conan.fans.weibo.service.ProvincesService;
import org.conan.fans.weibo.service.UserIncreaseService;
import org.conan.fans.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.Weibo;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

@Service
public class WeiboInitServiceImpl extends WeiboServiceImpl implements WeiboInitService {
    
    @Autowired
    AccountService accountService;
    @Autowired
    ProvincesService provincesService;
    
    @Autowired
    UserService userService;
    @Autowired
    UserIncreaseService userIncreaseService;
    
    @Autowired
    WeiboActionService weiboActionService;
    
    public AccountDTO initAPI(String code, String state) throws WeiboException {
        AccessToken token = weiboActionService.tokenByCode(code, state);
        long uid = Long.parseLong(token.getUid());
        AccountDTO dto = setToken(token.getAccessToken(), uid, token.getExpireIn(), state);
        TokenMap.tokenMaps.put(uid, dto);
        return dto;
    }
    
    public AccountDTO setToken(String token, long uid, String expireIn, String state) throws WeiboException {
        Weibo weibo = new Weibo();
        weibo.setToken(token);
        User user = weiboActionService.user(uid);// 加载用户
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", uid);
        AccountDTO dto = new AccountDTO(uid, new Timestamp(System.currentTimeMillis()), expireIn, null, state, user.getScreenName(), token);
        accountService.saveAccount(dto, paramMap);// 保存账号
        
        UserDTO u = new UserDTO();
        u.setUid(uid);
        userService.deleteUser(u);
        userService.saveUser(WeiboTransfer.user(user));// 保存用户
        
        userIncreaseService.userIncrease(uid, user);// 保存用户增长
        return dto;
    }
    
    @Override
    public void initProvinces() {
        // 插入新省
        List<ProvincesDTO> list = SinaProvinces.provinces();
        provincesService.deleteProvinces(new ProvincesDTO());
        for (ProvincesDTO dto : list) {
            provincesService.insertProvinces(dto);
        }
    }
    
    @Override
    public void initProvincesGeo(List<ProvincesDTO> list) {
        // 确定坐标
        Map<String, String> map = new HashMap<String, String>();
        for (ProvincesDTO dto : list) {
            String pname = null;
            if (dto.getCid() != null) {
                pname = dto.getName();
                map.putAll(GoogleMap.address2point(pname));
                dto.setLongitude(map.get("longitude"));
                dto.setLatitude(map.get("latitude"));
            } else {
                map.putAll(GoogleMap.address2point(pname + dto.getName()));
                dto.setLongitude(map.get("longitude"));
                dto.setLatitude(map.get("latitude"));
            }
            provincesService.updateProvinces(dto);
            map.clear();
        }
    }
    
    // public void initUid(long uid) {
    // Map<String, Object> paramMap = new HashMap<String, Object>();
    // paramMap.put("uid", uid);
    // AccountDTO dto = accountService.getAccountOne(paramMap);
    // TokenMap.tokenMaps.put(uid, dto);
    // }
    
}
