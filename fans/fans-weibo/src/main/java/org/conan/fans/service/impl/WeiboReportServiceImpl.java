package org.conan.fans.service.impl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.conan.base.service.SpringService;
import org.conan.fans.service.WeiboReportService;
import org.conan.fans.system.model.ConfigDTO;
import org.conan.fans.system.service.ConfigService;
import org.conan.r.service.RServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeiboReportServiceImpl extends WeiboServiceImpl implements WeiboReportService {
    
    @Autowired
    RServiceImpl rService;
    @Autowired
    ConfigService configService;
    
    @Override
    public void gender(long uid) {
        Map<String, String> params = paserConfig(uid, SpringService.REST_GENDER);
        rService.run(params.get("file"), params);
    }
    
    @Override
    public void wage(long uid) {
        Map<String, String> params = paserConfig(uid, SpringService.REST_WAGE);
        rService.run(params.get("file"), params);
    }
    
    @Override
    public void verifer(long uid) {
        Map<String, String> params = paserConfig(uid, SpringService.REST_VERIFER);
        rService.run(params.get("file"), params);
    }
    
    @Override
    public void cloud(long uid) {
        Map<String, String> params = paserConfig(uid, SpringService.REST_CLOUD);
        rService.run(params.get("file"), params);
    }
    
    @Override
    public void face(long uid) {
        Map<String, String> params = paserConfig(uid, SpringService.REST_FACE);
        rService.run(params.get("file"), params);
    }
    
    @Override
    public void increase(long uid) {
        Map<String, String> params = paserConfig(uid, SpringService.REST_INCREASE);
        rService.run(params.get("file"), params);
    }
    
    @Override
    public void map(long uid) {
        Map<String, String> params = paserConfig(uid, SpringService.REST_MAP);
        rService.run(params.get("file"), params);
    }
    
    @Override
    public void rado(long uid) {
        Map<String, String> params = paserConfig(uid, SpringService.REST_RADO);
        rService.run(params.get("file"), params);
    }
    
    @Override
    public void all(long uid) {
        gender(uid);
        wage(uid);
        verifer(uid);
        cloud(uid);
        face(uid);
        increase(uid);
        map(uid);
        rado(uid);
    }
    
    private Map<String, String> paserConfig(long uid, String type) {
        ConfigDTO config = configService.config(type);
        Map<String, String> params = new HashMap<String, String>();
        params.put("uid", String.valueOf(uid));
        params.put("path", MessageFormat.format(config.getOutput(), String.valueOf(uid)));
        params.put("file", config.getR());
        return params;
    }


    
}
