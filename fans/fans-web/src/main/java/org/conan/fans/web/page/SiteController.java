package org.conan.fans.web.page;

import org.conan.fans.service.WeiboActionService;
import org.conan.fans.service.WeiboInitService;
import org.conan.fans.web.WebController;
import org.conan.fans.weibo.model.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@SessionAttributes("dd")
public class SiteController extends WebController {
    
    private Logger log = LoggerFactory.getLogger(SiteController.class);
    
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
    public String home(ModelMap model) {
        AccountDTO user = new AccountDTO();
        user.setUid(1999250817l);
        user.setScreen_name("Gmail");
        
        model.addAttribute("accountDTO", user);
        model.addAttribute("dd", "11111111111111111");
        model.addAttribute("auth", true);
        log.info(model.get("dd").toString());
        return "home";
    }
    
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public String load(@ModelAttribute("dd") String s, ModelMap model) {
//        log.info(accountDTO.getUid().toString());
//        log.info(accountDTO.getScreen_name());
        
        log.info(s);
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
