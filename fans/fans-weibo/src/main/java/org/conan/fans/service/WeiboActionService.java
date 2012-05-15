package org.conan.fans.service;

import java.io.IOException;

import weibo4j.model.Status;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public interface WeiboActionService extends WeiboService {
    
    Status send(String msg) throws WeiboException ;//发微博
    Status send(String msg, String image)throws WeiboException,IOException ;//发微博图片
    Status repost(long sid, String msg, int comment)throws WeiboException;//转发微博
    Status remove(long sid)throws WeiboException ;//删除微博
    
    User follow(long uid)throws WeiboException ;//关注用户
    User follow(String screen)throws WeiboException ;
    User unfollow(long uid)throws WeiboException ;//取消关注
    User unfollow(String screen)throws WeiboException ;

}
