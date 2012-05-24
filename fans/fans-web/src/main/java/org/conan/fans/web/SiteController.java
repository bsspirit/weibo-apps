package org.conan.fans.web;

import org.conan.fans.service.WeiboActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 标准站点的操作
 * 
 * @author conan
 */
@Controller
public class SiteController extends WebController {
    
    @Autowired
    WeiboActionService action;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.put("authorize", action.authorize());
        return "index";
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
    
    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback() {
        return "redirect:/home";
    }
    
        
    void setToken(long uid, String token) {
        
    }
    
    void load(long uid) {
        
    }
    
}
