package org.conan.fans.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.conan.fans.service.WeiboActionService;
import org.springframework.stereotype.Service;

import weibo4j.Friendships;
import weibo4j.Timeline;
import weibo4j.http.ImageItem;
import weibo4j.model.Status;
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
