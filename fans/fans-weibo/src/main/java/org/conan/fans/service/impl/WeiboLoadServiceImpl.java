package org.conan.fans.service.impl;

import java.util.List;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboLoadService;
import org.conan.fans.service.util.WeiboTransfer;
import org.conan.fans.weibo.model.UserBirelateDTO;
import org.conan.fans.weibo.model.UserDTO;
import org.conan.fans.weibo.model.UserRelateDTO;
import org.conan.fans.weibo.service.UserBirelateService;
import org.conan.fans.weibo.service.UserRelateService;
import org.conan.fans.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.model.User;
import weibo4j.model.WeiboException;

@Service
public class WeiboLoadServiceImpl extends WeiboServiceImpl implements WeiboLoadService {
    
    @Autowired
    UserService userService;
    @Autowired
    UserRelateService userRelateService;
    @Autowired
    UserBirelateService userBirelateService;
    @Autowired
    WeiboActionService weiboActionService;
    
    @Override
    public void fansAll(long uid) throws WeiboException {
        fansIDs(uid);
        fans(uid);
    }
    
    public void fans(long uid) throws WeiboException {
        weiboActionService.setUid(uid);
        
        for (User u : weiboActionService.fans(uid)) {
            try {
                userService.insertUser(WeiboTransfer.user(u));
            } catch (Exception e) {
            }
        }
    }
    
    public void fansIDs(long uid) throws WeiboException {
        weiboActionService.setUid(uid);
        
        String[] ids = weiboActionService.fansIds(uid);
        userRelateService.deleteUserRelate(new UserRelateDTO(uid, null, null));
        for (String id : ids) {
            UserRelateDTO dto = new UserRelateDTO(uid, Long.parseLong(id), null);
            userRelateService.insertUserRelate(dto);
        }
    }
    
    public void bifansIDs(long uid) throws WeiboException {
        weiboActionService.setUid(uid);
        
        String[] ids = weiboActionService.bifansIds(uid);
        userBirelateService.deleteUserBirelate(new UserBirelateDTO(uid, null, null));
        for (String id : ids) {
            UserBirelateDTO dto = new UserBirelateDTO(uid, Long.parseLong(id), null);
            userBirelateService.insertUserBirelate(dto);
        }
    }
    
    public void usersByUids(long[] uids, long uid) throws WeiboException {
        weiboActionService.setUid(uid);
        
        List<User> list = weiboActionService.users(uids);
        for (User u : list) {
            UserDTO dto = WeiboTransfer.user(u);
            userService.insertUser(dto);
        }
    }
}
