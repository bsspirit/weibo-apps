package org.conan.fans.service;

import org.springframework.stereotype.Component;

@Component
public class WeiboToken {

    private String token = "2.00v9eSLCQ6BahBac718d168101dDD7";
    private String uid = "1999250817";
    private String name = "Conan_Z";
    private String screen = "Conan_Z";

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

}
