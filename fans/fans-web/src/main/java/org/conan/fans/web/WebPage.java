package org.conan.fans.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.conan.SpringInitialize;
import org.conan.fans.service.util.TokenMap;
import org.springframework.context.ApplicationContext;

import weibo4j.model.WeiboException;

abstract public class WebPage extends HttpServlet {

    private static final long serialVersionUID = 121212121L;
    protected ApplicationContext ctx = SpringInitialize.getContext();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            action(req, resp, "GET");
        } catch (WeiboException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            action(req, resp, "POST");
        } catch (WeiboException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    abstract protected void action(HttpServletRequest re, HttpServletResponse res, String type) throws Exception;

    protected void logonSession(HttpSession session, long uid) {
        session.setAttribute("logon", true);
        session.setAttribute("uid", uid);
        session.setAttribute("screen", TokenMap.tokenMaps.get(uid).getScreen_name());
    }

    protected void logoutSession(HttpSession session) {
        session.removeAttribute("uid");
        session.removeAttribute("logon");
    }

}
