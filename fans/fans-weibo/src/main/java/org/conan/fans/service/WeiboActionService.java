package org.conan.fans.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import weibo4j.http.AccessToken;
import weibo4j.model.Comment;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.School;
import weibo4j.model.Status;
import weibo4j.model.Tag;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public interface WeiboActionService extends WeiboService {
    
    //微博
    Status send(String msg) throws WeiboException ;//发微博
    Status send(String msg, String image)throws WeiboException,IOException ;//发微博图片
    Status repost(long sid, String msg, int comment)throws WeiboException;//转发微博
    Status remove(long sid)throws WeiboException ;//删除微博
    
    //评论
    Comment comment(long tid, String comment) throws WeiboException;//评论
    Comment delComment(long cid) throws WeiboException;//删除评论
    
    //关系
    User follow(long uid)throws WeiboException ;//关注用户
    User follow(String screen)throws WeiboException ;
    User unfollow(long uid)throws WeiboException ;//取消关注
    User unfollow(String screen)throws WeiboException ;
    List<User> fans(long uid)throws WeiboException ;//获得粉丝用户
    String[] fansIds(long uid)throws WeiboException;//获得粉丝ID列表
    String[] bifansIds(long uid)throws WeiboException;//获得相互关注粉丝ID列表
    
    //用户
    User user(long uid)throws WeiboException;
    User user(String screen)throws WeiboException;
    User userByDomain(String domain)throws WeiboException;
    ArrayList<User> users(long[] uids)throws WeiboException;
    
    //标签
    List<Tag> tags(long uid) throws WeiboException;
    long tag(String tag) throws WeiboException;
    long delTag(int tagId) throws WeiboException;
    
    //账号
    String accUid() throws WeiboException;
    String accPrivacy() throws WeiboException;
    List<School> accSchools() throws WeiboException;
    RateLimitStatus accLimit() throws WeiboException;
    
    //推荐
    List<Tag> tagsSuggestion()throws WeiboException;
    String hotUsersSuggestion()throws WeiboException;
    String hotUsersSuggestion(String category)throws WeiboException;
    List<Status> hotTweetSuggestion(int type, int isPic)throws WeiboException;
    String hotFavoriteSuggestion()throws WeiboException;
    
    //Oauth
    AccessToken tokenByCode(String code, String state)throws WeiboException;
    String authorize();
    

}
