package org.conan.fans.service.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 两种加载数据的方法
 * 
 * @author conan
 * 
 */
public class Transport {
    
    /**
     * 同步方法
     */
    public List<String> synchronous() {
        return load();
    }
    
    /**
     * 异步方法
     */
    public void asynchronous() {
        new Thread().start();
    }
    
    /**
     * 导步方法的回调
     */
    public List<String> callback() {
        return null;
    }
    
    public List<String> load() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add("add" + i);
        }
        return list;
    }
    
    public static void main(String[] args) {
        
    }
    
}
