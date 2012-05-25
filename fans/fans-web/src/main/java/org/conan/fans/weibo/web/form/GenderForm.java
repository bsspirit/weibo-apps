package org.conan.fans.weibo.web.form;

import org.conan.base.BaseObject;

public class GenderForm extends BaseObject {

    private static final long serialVersionUID = -722199959999238694L;

    private String img;
    private String tweet;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

}
