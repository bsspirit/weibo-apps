package org.conan.fans.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.impl.WeiboActionServiceImpl;

@WebServlet("/")
public class IndexPage extends WebPage {

    private static final long serialVersionUID = 4494046744057079184L;

    public void action(HttpServletRequest re, HttpServletResponse res, String type) throws ServletException, IOException {
        Boolean logon = (Boolean) re.getSession().getAttribute("logon");
        if (logon != null && logon) {
            res.sendRedirect("home");
            return;
        }

        re.getSession().setAttribute("logon", false);
        WeiboActionService action = ctx.getBean(WeiboActionServiceImpl.class);
        re.setAttribute("authorize", action.authorize());
        re.getRequestDispatcher("index.jsp").forward(re, res);
    }
}
