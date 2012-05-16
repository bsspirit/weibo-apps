package org.conan.fans.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.conan.fans.service.WeiboActionService;
import org.springframework.stereotype.Service;

import weibo4j.Comments;
import weibo4j.Friendships;
import weibo4j.Tags;
import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.http.ImageItem;
import weibo4j.model.Comment;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.School;
import weibo4j.model.Status;
import weibo4j.model.Tag;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

@Service
public class WeiboActionServiceImpl extends WeiboServiceImpl implements WeiboActionService {
    
    public Status send(String msg) throws WeiboException {
        return new Timeline().UpdateStatus(msg);
    }
    
    public Status send(String msg, String image) throws WeiboException, IOException {
        return new Timeline().UploadStatus(msg, readFileImage(image));
    }
    
    public Status repost(long sid, String msg, int comment) throws WeiboException {
        return new Timeline().Repost(String.valueOf(sid), msg, comment);
    }
    
    public Status remove(long sid) throws WeiboException {
        return new Timeline().Destroy(String.valueOf(sid));
    }
    
    public Comment comment(long tid, String comment) throws WeiboException {
        return new Comments().createComment(comment, String.valueOf(tid));
    }
    
    public Comment delComment(long cid) throws WeiboException {
        return new Comments().destroyComment(String.valueOf(cid));
    }
    
    public User follow(long uid) throws WeiboException {
        return new Friendships().createFriendshipsById(String.valueOf(uid));
    }
    
    public User follow(String screen_name) throws WeiboException {
        return new Friendships().createFriendshipsByName(screen_name);
    }
    
    public User unfollow(long uid) throws WeiboException {
        return new Friendships().destroyFriendshipsDestroyById(String.valueOf(uid));
    }
    
    public User unfollow(String screen_name) throws WeiboException {
        return new Friendships().destroyFriendshipsDestroyByName(screen_name);
    }
    
    @Override
    public User user(long uid) throws WeiboException {
        return new Users().showUserById(String.valueOf(uid));
    }
    
    @Override
    public User user(String screen) throws WeiboException {
        return new Users().showUserByScreenName(screen);
    }
    
    @Override
    public User userByDomain(String domain) throws WeiboException {
        return new Users().showUserByDomain(domain);
    }
    
    @Override
    public List<Tag> tags(long uid) throws WeiboException {
        return new Tags().getTags(String.valueOf(uid));
    }
    
    @Override
    public long tag(String tag) throws WeiboException {
        // TODO
        // return new Tags().createTags(tag).toString();
        return 0;
    }
    
    @Override
    public long delTag(int tagId) throws WeiboException {
        // TODO
        // return new Tags().destoryTag(tagId);
        return 0;
    }
    
    @Override
    public String accUid() throws WeiboException {
        // TODO
        // return new Account().getUid();
        return "";
    }
    
    @Override
    public String accPrivacy() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<School> accSchools() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public RateLimitStatus accLimit() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<Tag> tagsSuggestion() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String hotUsersSuggestion() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String hotUsersSuggestion(String category) throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<Status> hotTweetSuggestion(int type, int isPic) throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String hotFavoriteSuggestion() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public AccessToken tokenByCode(String code) throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }
    
    private ImageItem readFileImage(String filename) throws IOException, WeiboException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filename));
        int len = bufferedInputStream.available();
        byte[] bytes = new byte[len];
        int r = bufferedInputStream.read(bytes);
        if (len != r) {
            bytes = null;
            throw new IOException("Read File Error!!");
        }
        bufferedInputStream.close();
        ImageItem pic = new ImageItem("pic", bytes);
        return pic;
    }
}
