package org.conan.fans.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.util.TokenMap;
import org.springframework.stereotype.Service;

import weibo4j.Comments;
import weibo4j.Friendships;
import weibo4j.Oauth;
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
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.util.URLEncodeUtils;

@Service
public class WeiboActionServiceImpl extends WeiboServiceImpl implements WeiboActionService {

    public Status send(String msg) throws WeiboException {
        return new Timeline().UpdateStatus(URLEncodeUtils.encodeURL(msg));
    }

    public Status send(String msg, String image) throws WeiboException, IOException {
        return new Timeline().UploadStatus(URLEncodeUtils.encodeURL(msg), readFileImage(image));
    }

    public Status repost(long sid, String msg, int comment) throws WeiboException {
        return new Timeline().Repost(String.valueOf(sid), URLEncodeUtils.encodeURL(msg), comment);
    }

    public Status remove(long sid) throws WeiboException {
        return new Timeline().Destroy(String.valueOf(sid));
    }

    public Comment comment(long tid, String comment) throws WeiboException {
        return new Comments().createComment(URLEncodeUtils.encodeURL(comment), String.valueOf(tid));
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

    public List<User> fans(long uid) throws WeiboException {
        List<User> list = new ArrayList<User>();
        Friendships fm = new Friendships();
        long current = 0;
        long count = 10;
        do {
            UserWapper users = fm.getFollowersById(String.valueOf(uid), (int) count, (int) current);
            for (User u : users.getUsers()) {
                list.add(u);
            }
            current = users.getNextCursor();
            count = users.getTotalNumber() - current > 200 ? 200 : users.getTotalNumber() - current;
        } while (current != 0);
        return list;
    }

    public String[] fansIds(long uid) throws WeiboException {
        return new Friendships().getFollowersIdsById(String.valueOf(uid));
    }

    public String[] bifansIds(long uid) throws WeiboException {
        return new Friendships().getFriendsBilateralIds(String.valueOf(uid));
    }

    public User user(long uid) throws WeiboException {
        return new Users().showUserById(String.valueOf(uid));
    }

    public User user(String screen) throws WeiboException {
        return new Users().showUserByScreenName(screen);
    }

    public User userByDomain(String domain) throws WeiboException {
        return new Users().showUserByDomain(domain);
    }

    public ArrayList<User> users(long[] uids) throws WeiboException {
        ArrayList<User> list = new ArrayList<User>();
        for (long uid : uids)
            list.add(user(uid));
        return list;
    }

    public List<Tag> tags(long uid) throws WeiboException {
        return new Tags().getTags(String.valueOf(uid));
    }

    public long tag(String tag) throws WeiboException {
        // TODO
        // return new Tags().createTags(tag).toString();
        return 0;
    }

    public long delTag(int tagId) throws WeiboException {
        // TODO
        // return new Tags().destoryTag(tagId);
        return 0;
    }

    public String accUid() throws WeiboException {
        // TODO
        // return new Account().getUid();
        return "";
    }

    public String accPrivacy() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<School> accSchools() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }

    public RateLimitStatus accLimit() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Tag> tagsSuggestion() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }

    public String hotUsersSuggestion() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }

    public String hotUsersSuggestion(String category) throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Status> hotTweetSuggestion(int type, int isPic) throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }

    public String hotFavoriteSuggestion() throws WeiboException {
        // TODO Auto-generated method stub
        return null;
    }

    public AccessToken tokenByCode(String code, String state) throws WeiboException {
        Oauth oauth = TokenMap.oauthMaps.get(state);
        AccessToken token = oauth.getAccessTokenByCode(code);
        TokenMap.oauthMaps.remove(state);
        return token;
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

    @Override
    public String authorize() {
        String state = String.valueOf(System.currentTimeMillis());
        Oauth oauth = new Oauth();
        TokenMap.oauthMaps.put(state, oauth);
        return oauth.authorize("code", state);
    }

}
