package org.conan.r.service;

import java.util.Map;

import org.rosuda.JRI.Rengine;

abstract public class RService {
    
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
            System.err.println("** Version mismatch - Java files don't match library version.");
            System.exit(1);
        }
        
        System.out.println("Creating Rengine (with vanilla)");
        r = new Rengine(new String[] { "--vanilla" }, false, null);
        if (!r.waitForR()) {
            System.out.println("Cannot load R");
            return;
        }
    }
    
    private void destory() {
        r.end();
    }
    
}
