package org.conan.r.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract public class RService {
    
    final private static Logger log = LoggerFactory.getLogger(RServiceImpl.class);
    
    final private static boolean SHOW_CONSOLE = true;
    
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
        r = new Rengine(new String[] { "--vanilla" }, false, (SHOW_CONSOLE ? new TextConsole() : null));
        if (!r.waitForR()) {
            log.error("Cannot load R");
            return;
        }
    }
    
    private void destory() {
        r.end();
    }
}

class TextConsole implements RMainLoopCallbacks {
    final private static Logger log = LoggerFactory.getLogger(RServiceImpl.class);
    
    public void rWriteConsole(Rengine re, String text, int oType) {
        if (text != null && !text.equals("") && text.length() > 1)
            log.debug(text);
    }
    
    public void rBusy(Rengine re, int which) {
        log.debug("rBusy(" + which + ")");
    }
    
    public String rReadConsole(Rengine re, String prompt, int addToHistory) {
        log.debug(prompt);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            return (s == null || s.length() == 0) ? s : s + "\n";
        } catch (Exception e) {
            log.debug("jriReadConsole exception: " + e.getMessage());
        }
        return null;
    }
    
    public void rShowMessage(Rengine re, String message) {
        log.debug("rShowMessage \"" + message + "\"");
    }
    
    public String rChooseFile(Rengine re, int newFile) {
        return null;
    }
    
    public void rFlushConsole(Rengine re) {
    }
    
    public void rLoadHistory(Rengine re, String filename) {
    }
    
    public void rSaveHistory(Rengine re, String filename) {
    }
}
