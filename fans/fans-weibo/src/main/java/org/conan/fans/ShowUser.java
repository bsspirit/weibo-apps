package org.conan.fans;

import weibo4j.Friendships;
import weibo4j.Weibo;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

/**
 * AccessToken [accessToken=2.00v9eSLCQ6BahB4fdf983fa8ga2C3E, expireIn=86400, refreshToken=,uid=1999250817]
 * 
 */
public class ShowUser {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String access_token = "2.00v9eSLCQ6BahB4fdf983fa8ga2C3E";
        Weibo weibo = new Weibo();
        weibo.setToken(access_token);
//        String uid = "1999250817";
//        Users um = new Users();
//        try {
//            User user = um.showUserById(uid);
//            System.out.println(user.toString());
//        } catch (WeiboException e) {
//            e.printStackTrace();
//        }
        
        
        Friendships fm = new Friendships();
        String screen_name ="Conan_Z";
        try {
            UserWapper users = fm.getFollowersByName(screen_name,200,0);
            for(User u : users.getUsers()){
//                Log.logInfo(u.toString());
            }
            System.out.println(users.getNextCursor());
            System.out.println(users.getPreviousCursor());
            System.out.println(users.getTotalNumber());
        } catch (WeiboException e) {
            e.printStackTrace();
        }
    }

}