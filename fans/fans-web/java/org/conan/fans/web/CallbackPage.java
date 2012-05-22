package org.conan.fans.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.impl.WeiboInitServiceImpl;

@WebServlet("/callback")
public class CallbackPage extends WebPage {

    private static final long serialVersionUID = 1111111111212121L;

    @Override
    protected void action(HttpServletRequest re, HttpServletResponse res, String type) throws Exception {
        String code = re.getParameter("code");
        String state = re.getParameter("state");
        WeiboInitService init = ctx.getBean(WeiboInitServiceImpl.class);
        long uid = init.initAPI(code, state);
        super.logonSession(re.getSession(), uid);
        res.sendRedirect("home");
    }

}
