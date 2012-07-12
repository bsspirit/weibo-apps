package org.conan.fans.weibo.web.rest;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.conan.base.service.SpringService;
import org.conan.fans.service.WeiboCheckService;
import org.conan.fans.service.WeiboInitService;
import org.conan.fans.service.WeiboLoadService;
import org.conan.fans.service.WeiboPushService;
import org.conan.fans.service.WeiboReportService;
import org.conan.fans.system.model.ConfigDTO;
import org.conan.fans.system.service.ConfigService;
import org.conan.fans.weibo.service.AccountService;
import org.conan.fans.weibo.service.UserService;
import org.conan.fans.weibo.web.WebController;
import org.conan.fans.weibo.web.form.AgeForm;
import org.conan.fans.weibo.web.form.CloudForm;
import org.conan.fans.weibo.web.form.FaceForm;
import org.conan.fans.weibo.web.form.GenderForm;
import org.conan.fans.weibo.web.form.IncreaseForm;
import org.conan.fans.weibo.web.form.RadoForm;
import org.conan.fans.weibo.web.form.SocialNameForm;
import org.conan.fans.weibo.web.form.SocialNodeForm;
import org.conan.fans.weibo.web.form.UserForm;
import org.conan.fans.weibo.web.form.VeriferForm;
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
    @Autowired
    WeiboPushService push;
    @Autowired
    WeiboCheckService check;
    
    /**
     * 查询API e.g. 1999250817
     */
    @RequestMapping(value = "/wage/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> age(@PathVariable(value = "uid") String uid) {
        log.info("wage => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_WAGE);
        AgeForm form = new AgeForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(MessageFormat.format(config.getTemplate(), ""));
        return new ResponseEntity<AgeForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/verifer/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> v(@PathVariable(value = "uid") String uid) {
        log.info("verifer => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_VERIFER);
        VeriferForm form = new VeriferForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(MessageFormat.format(config.getTemplate(), ""));
        return new ResponseEntity<VeriferForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/gender/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> gender(@PathVariable(value = "uid") String uid) {
        log.info("gender => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_GENDER);
        GenderForm form = new GenderForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        return new ResponseEntity<GenderForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/cloud/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> cloud(@PathVariable(value = "uid") String uid) {
        log.info("cloud => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_CLOUD);
        CloudForm form = new CloudForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        return new ResponseEntity<CloudForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/face/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> face(@PathVariable(value = "uid") String uid) {
        log.info("face => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_FACE);
        FaceForm form = new FaceForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        return new ResponseEntity<FaceForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/increase/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> increase(@PathVariable(value = "uid") String uid) {
        log.info("increase => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_INCREASE);
        IncreaseForm form = new IncreaseForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        return new ResponseEntity<IncreaseForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/map/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> map(@PathVariable(value = "uid") String uid) {
        log.info("map => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_MAP);
        IncreaseForm form = new IncreaseForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        return new ResponseEntity<IncreaseForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/rado/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> rado(@PathVariable(value = "uid") String uid) {
        log.info("rado => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_RADO);
        RadoForm form = new RadoForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        return new ResponseEntity<RadoForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/socialNode/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> socialNode(@PathVariable(value = "uid") String uid) {
        log.info("socialNode => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_SOCIAL_NODE);
        SocialNodeForm form = new SocialNodeForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        form.setStatus(check.limitLoadCheck(Integer.parseInt(uid), SpringService.REST_SOCIAL_NODE));
        return new ResponseEntity<SocialNodeForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/socialName/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> socialName(@PathVariable(value = "uid") String uid) {
        log.info("socialName => " + uid);
        ConfigDTO config = configService.config(SpringService.REST_SOCIAL_NAME);
        SocialNameForm form = new SocialNameForm();
        form.setImg(MessageFormat.format(config.getImgUrl(), uid));
        form.setTweet(config.getTemplate());
        return new ResponseEntity<SocialNameForm>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> user(@PathVariable(value = "uid") String uid) {
        log.info("user => " + uid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        UserForm form = new UserForm(userService.getUserOne(map));
        return new ResponseEntity<UserForm>(form, HttpStatus.OK);
    }
    
    /**
     * 粉丝列表
     */
    @RequestMapping(value = "/fans/{type}/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> fans(@PathVariable(value = "uid") String uid, @PathVariable(value = "type") String type) {
        log.info("fans　" + type + " => " + uid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        UserForm form = new UserForm(userService.getUserOne(map));
        return new ResponseEntity<UserForm>(form, HttpStatus.OK);
    }
    
    /**
     * 出始化oauth信息
     */
    @RequestMapping(value = "/oauth/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> oauth(@PathVariable(value = "uid") Long uid, @RequestParam(value = "code", required = true) String code, @RequestParam(value = "state", required = true) String state, @RequestParam(value = "expireIn", required = false) String expireIn) throws WeiboException {
        log.info("oauth =>" + uid + "," + code);
        init.setToken(code, uid, expireIn, state);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        UserForm form = new UserForm(userService.getUserOne(map));
        return new ResponseEntity<UserForm>(form, HttpStatus.OK);
    }
    
    /**
     * 加载微博数据
     */
    @RequestMapping(value = "/load/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> load(@PathVariable(value = "uid") Long uid, @RequestParam(value = "commit", required = false, defaultValue = "false") boolean commit) throws WeiboException {
        log.info("load => " + uid);
        if (commit || check.limitCheck(uid, SpringService.LIMIT_WEIBO_LOAD_FANS)) {
            load.fansAll(uid);
        }
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }
    
    /**
     * 生成报表
     */
    @RequestMapping(value = "/report/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> report(@PathVariable(value = "uid") Long uid, @RequestParam(value = "commit", required = false, defaultValue = "false") boolean commit) throws WeiboException {
        log.info("report => " + uid);
        if (commit || check.limitCheck(uid, SpringService.LIMIT_REPORT_FANS)) {
            report.all(uid);
        }
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }
    
    /**
     * 发送微博
     */
    @RequestMapping(value = "/send/{type}/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> send(@PathVariable(value = "uid") Long uid, @PathVariable(value = "type") String type) throws WeiboException, IOException {
        log.info("send " + type + " => " + uid);
        ConfigDTO config = configService.config(type);
        push.send(uid, config.getTemplate() + "  -" + System.currentTimeMillis(), MessageFormat.format(config.getOutput(), String.valueOf(uid)));
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }
    
    /**
     * 关注
     */
    @RequestMapping(value = "/follow/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> follow(@PathVariable(value = "uid") Long uid, @RequestParam(value = "fid", required = false) Long fid, @RequestParam(value = "fscreen", required = false) String fscreen) throws WeiboException {
        if (fscreen != null && !fscreen.equals("")) {
            log.info("follow " + fscreen + " => " + uid);
            push.follow(uid, fscreen);
        } else {
            log.info("follow " + fid + " => " + uid);
            push.follow(uid, fid);
        }
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }
    
//    @RequestMapping(value = "/demo", method = RequestMethod.GET)
//    public HttpEntity<?> demo() throws WeiboException {
//        ProvinceUtil.initProvince();
//        return new ResponseEntity<Integer>(1, HttpStatus.OK);
//    }
}
