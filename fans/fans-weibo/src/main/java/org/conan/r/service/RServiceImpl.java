package org.conan.r.service;

import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RServiceImpl extends RService {
    
    @Override
    public void call(String file, Map<String, String> params) {
        System.out.println(r.eval("ls()"));
        Iterator<String> iter = params.keySet().iterator();
        while (iter.hasNext()) {
            String k = iter.next();
            String v = params.get(k);
            r.assign(k, params.get(k));
            System.out.printf("%s<-%s\n", k, v);
        }
        String source = "source(\"" + file + "\",echo=TRUE,encoding=\"utf-8\")";
        System.out.println(source);
        r.eval(source);
    }
}
