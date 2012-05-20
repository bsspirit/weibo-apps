package org.conan.fans.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.conan.fans.service.impl.WeiboInitServiceImpl;

@WebServlet("/home")
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1000000000008L;

    @Override
    protected void action(HttpServletRequest re, HttpServletResponse res, String type) throws Exception {

        String user = re.getParameter("uid");
        if (user != null && user.length() > 0) {//登陆
            long uid = Long.parseLong(user);
            ctx.getBean(WeiboInitServiceImpl.class).initUid(uid);
            super.logonSession(re.getSession(), uid);
        }

        re.getRequestDispatcher("home.jsp").forward(re, res);
    }

}
