package org.conan.r.service;

import java.util.Map;

import org.rosuda.JRI.Rengine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract public class RService {
    
    final private static Logger log = LoggerFactory.getLogger(RServiceImpl.class);
    
    public static Rengine r = null;
    
    abstract protected void call(String file, Map<String, String> params);
    
    public void run(String file, Map<String, String> params) {
        initR();
        call(file, params);
        destory();
    }
    
    private void initR() {
        if (r != null)
            return;
        
        if (!Rengine.versionCheck()) {
            log.error("** Version mismatch - Java files don't match library version.");
            System.exit(1);
        }
        
        log.debug("Creating Rengine (with vanilla)");
        r = new Rengine(new String[] { "--vanilla" }, false, null);
        if (!r.waitForR()) {
            log.error("Cannot load R");
            return;
        }
    }
    
    private void destory() {
        r.end();
    }
    
}
