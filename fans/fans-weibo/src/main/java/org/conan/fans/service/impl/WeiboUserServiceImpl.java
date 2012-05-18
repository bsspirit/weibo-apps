package org.conan.fans.service.impl;

import java.util.List;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboUserService;
import org.conan.fans.service.util.WeiboTransfer;
import org.conan.fans.weibo.model.UserDTO;
import org.conan.fans.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.model.User;
import weibo4j.model.WeiboException;

@Service
public class WeiboUserServiceImpl extends WeiboServiceImpl implements WeiboUserService {
    
    @Autowired
    WeiboActionService weiboActionService;
    @Autowired
    UserService userService;
    
    public void usersByUids(long[] uids) throws WeiboException {
        List<User> list = weiboActionService.users(uids);
        for (User u : list) {
            UserDTO dto = WeiboTransfer.user(u);
            userService.insertUser(dto);
        }
    }
    
}
