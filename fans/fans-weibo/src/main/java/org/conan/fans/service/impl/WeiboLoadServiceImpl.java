package org.conan.fans.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.conan.base.service.SpringService;
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
import org.springframework.dao.DuplicateKeyException;
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
        key(uid);
        fansIDs(uid);
        fans(uid);
        bifansIDs(uid);
    }
    
    public void fans(long uid) throws WeiboException {
        for (User u : weiboActionService.fans(uid)) {
            try {
                UserDTO dto = new UserDTO();
                dto.setUid(Long.parseLong(u.getId()));
                userService.deleteUser(dto);
                userService.insertUser(WeiboTransfer.user(u));
            } catch (Exception e) {
            }
        }
    }
    
    // update default=FALSE
    public void fansIDs(long uid) throws WeiboException {
        fansIDs(uid, false);
    }
    
    public void fansIDs(long uid, boolean update) throws WeiboException {
        String[] ids = weiboActionService.fansIds(uid);
        if (update) { // delete the old users
            userRelateService.deleteUserRelate(new UserRelateDTO(uid, null, null));
        }
        
        for (String id : ids) {
            UserRelateDTO dto = new UserRelateDTO(uid, Long.parseLong(id), null);
            try {
                userRelateService.insertUserRelate(dto);
            } catch (DuplicateKeyException e) { // ignore DuplicateKey
                break;
            }
        }
    }
    
    // update default=FALSE
    public void bifansIDs(long uid) throws WeiboException {
        bifansIDs(uid, false);
    }
    
    public void bifansIDs(long uid, boolean update) throws WeiboException {
        String[] ids = weiboActionService.bifansIds(uid);
        if (update) { // don't delete the old users
            userBirelateService.deleteUserBirelate(new UserBirelateDTO(uid, null, null));
        }
        
        for (String id : ids) {
            UserBirelateDTO dto = new UserBirelateDTO(uid, Long.parseLong(id), null);
            try {
                userBirelateService.insertUserBirelate(dto);
            } catch (DuplicateKeyException e) { // ignore DuplicateKey
                break;
            }
        }
    }
    
    /**
     * 粉丝的粉丝的IDs,前200个
     */
    public void fansFansIDS(long uid) throws WeiboException {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", uid);
        List<UserRelateDTO> list = userRelateService.getUserRelates(paramMap);
        for (int i = 0; i < list.size(); i++) {
            fansIDs(list.get(i).getFansid());
            if (i >= SpringService.WEIBO_LOAD_COUNT_200) {// 200的限制
                break;
            }
        }
    }
    
    public void usersByUids(long[] uids) throws WeiboException {
        List<User> list = weiboActionService.users(uids);
        for (User u : list) {
            UserDTO dto = WeiboTransfer.user(u);
            userService.insertUser(dto);
        }
    }
    
    public void key(long uid){
        weiboActionService.setUid(uid);
    }
}
