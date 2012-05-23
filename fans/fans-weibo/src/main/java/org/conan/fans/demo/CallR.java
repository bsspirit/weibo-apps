package org.conan.fans.demo;

import org.rosuda.JRI.Rengine;

public class CallR {
    
    public static Rengine r = null;
    
    public static void initR() {
        if (r != null) {
            return;
        }
        
        if (!Rengine.versionCheck()) {
            System.err.println("** Version mismatch - Java files don't match library version.");
            System.exit(1);
        }
        System.out.println("Creating Rengine (with arguments)");
        r = new Rengine(new String[] { "--vanilla" }, false, null);
        System.out.println("Rengine created, waiting for R");
        // the engine creates R is a new thread, so we should wait until it's ready
        if (!r.waitForR()) {
            System.out.println("Cannot load R");
            return;
        }
    }
    
    public static void destory() {
        r.end();
    }
    
    public static void main(String[] args) {
        initR();
        r.assign("uid", "1999250817");
        r.assign("path", "../R/image/v/");
        //r.eval("source(\"/home/conan/app/weibo-apps/fans/R/fansVerifer.R\",echo=TRUE,encoding=\"utf-8\")");
        r.eval("source(\"D:/weibo/fans/R/fansVerifer.R\",echo=TRUE,encoding=\"utf-8\")");
        destory();
    }
    
}
