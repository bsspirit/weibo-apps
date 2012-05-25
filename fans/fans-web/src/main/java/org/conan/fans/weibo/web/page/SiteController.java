package org.conan.fans.weibo.web.page;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboInitService;
import org.conan.fans.weibo.model.AccountDTO;
import org.conan.fans.weibo.web.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import weibo4j.model.WeiboException;

/**
 * 标准站点的操作
 * 
 * @author conan
 */
@Deprecated
@Controller
@SessionAttributes({ "user", "abc" })
public class SiteController extends WebController {

    @Autowired
    WeiboActionService action;
    @Autowired
    WeiboInitService init;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.put("authorize", action.authorize());
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        // AccountDTO user = new AccountDTO();
        // user.setUid(1999250817l);
        // user.setScreen_name("Gmail");
        // model.addAttribute("user", user);

        String abc = "Hello Conan";
        model.addAttribute("abc", abc);
        return "home";
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public String load(@ModelAttribute("abc") String abc) {
        // log.info(user.getUid().toString());
        // log.info(user.getScreen_name());

        System.out.println("abc====>" + abc + "\n");
        return "redirect:/home";
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback(ModelMap model, @RequestParam(value = "state", required = true) String state, @RequestParam(value = "code", required = true) String code) throws WeiboException {
        AccountDTO user = init.initAPI(code, state);
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", user);
            model.put("auth", true);
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/index";
    }

}
