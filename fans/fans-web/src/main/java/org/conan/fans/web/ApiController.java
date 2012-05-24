package org.conan.fans.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class ApiController extends WebController {
    
    //1999250817
    @RequestMapping(value = "/age/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> age(@PathVariable(value = "uid") String uid) {
        return new ResponseEntity<String>("age" + uid, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/gender/{uid}", method = RequestMethod.GET)
    public HttpEntity<?> gender(@PathVariable(value = "uid") String uid) {
        return new ResponseEntity<String>("gender" + uid, HttpStatus.OK);
    }
    
}
