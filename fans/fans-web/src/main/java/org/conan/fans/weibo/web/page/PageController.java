package org.conan.fans.weibo.web.page;

import org.conan.fans.weibo.model.AccountDTO;
import org.conan.fans.weibo.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Deprecated
@Controller
@RequestMapping("/page")
public class PageController extends WebController {
    
    // 1999250817
    @RequestMapping(value = "/age", method = RequestMethod.GET)
    public String age(@ModelAttribute("user") AccountDTO user) {
        System.out.println(user.getUid());
        System.out.println(user.getScreen_name());
        return "page/age";
    }
    
    @RequestMapping(value = "/gender", method = RequestMethod.GET)
    public String gender() {
        return "page/gender";
    }
    
    // @RequestMapping(value = "/gender", method = RequestMethod.GET)
    // public HttpEntity<?> gender() {
    // return new ResponseEntity<String>("gender" + uid, HttpStatus.OK);
    // }
    
}
