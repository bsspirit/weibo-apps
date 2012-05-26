package org.conan.fans.weibo.web.rest;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.WeiboLoadService;
import org.conan.fans.service.WeiboReportService;
import org.conan.fans.system.model.ConfigDTO;
import org.conan.fans.system.service.ConfigService;
import org.conan.fans.weibo.model.AccountDTO;
import org.conan.fans.weibo.service.AccountService;
import org.conan.fans.weibo.service.UserService;
import org.conan.fans.weibo.web.WebController;
import org.conan.fans.weibo.web.form.AgeForm;
import org.conan.fans.weibo.web.form.GenderForm;
import org.conan.fans.weibo.web.form.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import weibo4j.model.WeiboException;

@Controller
@RequestMapping("/api")
public class ApiController extends WebController {

    final private static Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    UserService userService;
    @Autowired
    ConfigService configService;
    @Autowired
    AccountService accountService;
    @Autowired
    WeiboInitService init;
    @Autowired
    WeiboLoadService load;
    @Autowired
    WeiboReportService report;

    // 1999250817
    @RequestMapping(value = "/wage/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> age(@PathVariable(value = "uid") String uid) {
        log.debug("age => " + uid);
        ConfigDTO config = configService.config("rest.wage");
        AgeForm form = new AgeForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(MessageFormat.format(config.getTemplate(), ""));
        return new ResponseEntity<AgeForm>(form, HttpStatus.OK);
    }

    @RequestMapping(value = "/gender/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> gender(@PathVariable(value = "uid") String uid) {
        log.debug("gender => " + uid);
        ConfigDTO config = configService.config("rest.gender");
        GenderForm form = new GenderForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        return new ResponseEntity<GenderForm>(form, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> user(@PathVariable(value = "uid") String uid) {
        log.debug("user => " + uid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        UserForm form = new UserForm(userService.getUserOne(map));
        return new ResponseEntity<UserForm>(form, HttpStatus.OK);
    }

    @RequestMapping(value = "/oauth/{uid}", method = RequestMethod.GET)
    public HttpEntity<AccountDTO> oauth(@PathVariable(value = "uid") Long uid, 
            @RequestParam(value = "code", required = true) String code,
            @RequestParam(value = "state", required = true) String state,
            @RequestParam(value = "expireIn", required = false) String expireIn) throws WeiboException {
        log.debug("oauth =>" + uid + "," + code);
        AccountDTO dto = init.setToken(code, uid, expireIn, state);
        return new ResponseEntity<AccountDTO>(dto, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/load/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> load(@PathVariable(value = "uid") Long uid) throws WeiboException {
        log.debug("load => " + uid);
        load.fansAll(uid);
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/report/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> report(@PathVariable(value = "uid") Long uid) throws WeiboException {
        log.debug("report => " + uid);
        report.all(uid);
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }

}
