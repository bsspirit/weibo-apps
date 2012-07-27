package org.conan.r.service;

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RServiceImpl extends RService {
    
    final private static Logger log = LoggerFactory.getLogger(RServiceImpl.class);
    
    public void call(String file) {
        call(file, null);
    }
    
    @Override
    public void call(String file, Map<String, String> params) {
        log.debug("Start R Calling");
        String wd = file.substring(0, file.lastIndexOf("/"));
        log.debug(r.eval("setwd(\"" + wd + "\")").toString());
        log.debug(r.eval("ls()").toString());
        if (params != null) {
            Iterator<String> iter = params.keySet().iterator();
            while (iter.hasNext()) {
                String k = iter.next();
                String v = params.get(k);
                r.assign(k, params.get(k));
                log.debug(k + "<-" + v + "\n");
            }
        }
        String source = "source(\"" + file + "\",echo=TRUE)";
        if (System.getProperties().get("os.name").toString().toLowerCase().contains("window")) {
            source = "source(\"" + file + "\",echo=TRUE,encoding=\"utf-8\")";
        }
        log.debug(source);
        r.eval(source);
        r.eval("rm(list=ls())");
        log.debug("Finish R Calling");
    }
    
    @Override
    public void call2(String content, Map<String, String> params) {
        log.debug("Start R Calling");
        //String wd = file.substring(0, file.lastIndexOf("/"));
        //log.debug(r.eval("setwd(\"" + wd + "\")").toString());
        log.debug(r.eval("ls()").toString());
        if (params != null) {
            Iterator<String> iter = params.keySet().iterator();
            while (iter.hasNext()) {
                String k = iter.next();
                String v = params.get(k);
                r.assign(k, params.get(k));
                log.debug(k + "<-" + v + "\n");
            }
        }
        //String source = "source(\"" + file + "\",echo=TRUE)";
        //if (System.getProperties().get("os.name").toString().toLowerCase().contains("window")) {
        //    source = "source(\"" + file + "\",echo=TRUE,encoding=\"utf-8\")";
        //}
        log.debug(content);
        r.eval(content);
        r.eval("rm(list=ls())");
        log.debug("Finish R Calling");
    }
    
}
