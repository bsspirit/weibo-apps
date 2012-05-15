package org.conan.fans.service.impl;

import org.conan.fans.service.WeiboFansService;
import org.conan.fans.service.util.WeiboToken;
import org.conan.fans.service.util.WeiboTransfer;
import org.conan.fans.weibo.model.UserDTO;
import org.conan.fans.weibo.model.UserRelateDTO;
import org.conan.fans.weibo.service.UserRelateService;
import org.conan.fans.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

@Service
public class WeiboFansServiceImpl extends WeiboServiceImpl implements WeiboFansService {

    @Autowired
    WeiboToken weiboToken;
    @Autowired
    UserService userService;
    @Autowired
    UserRelateService userRelateService;

    public void fansAction() throws WeiboException {
        Friendships fm = new Friendships();
        long current = 0;
        long count = 10;
        do {
            UserWapper users = fm.getFollowersById(weiboToken.getUid(), (int) count, (int) current);
            for (User u : users.getUsers()) {
                try {
                    UserDTO dto = WeiboTransfer.user(u);
                    userService.insertUser(dto);
                } catch (Exception e) {
                }
            }
            current = users.getNextCursor();
            count = users.getTotalNumber() - current > 200 ? 200 : users.getTotalNumber() - current;
        } while (current != 0);
    }

    public void fansIDsAction() throws WeiboException {
        Friendships fm = new Friendships();
        String[] ids = fm.getFollowersIdsById(weiboToken.getUid());

        UserRelateDTO d = new UserRelateDTO();
        d.setUid(Long.parseLong(weiboToken.getUid()));

        userRelateService.deleteUserRelate(d);
        for (String id : ids) {
            UserRelateDTO dto = new UserRelateDTO(Long.parseLong(weiboToken.getUid()), Long.parseLong(id), null);
            userRelateService.insertUserRelate(dto);
        }

    }
}
