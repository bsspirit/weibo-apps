package org.conan.fans.service.impl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> params = paserConfig(uid, "rest.gender");
        rService.run(params.get("file"), params);
    }

    @Override
    public void wage(long uid) {
        Map<String, String> params = paserConfig(uid, "rest.wage");
        rService.run(params.get("file"), params);
    }

    @Override
    public void verifer(long uid) {
        Map<String, String> params = paserConfig(uid, "rest.verifer");
        rService.run(params.get("file"), params);
    }

    @Override
    public void fansCloud(long uid) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("uid", String.valueOf(uid));
        params.put("path", "../R/image/cloud/");
        String file = "D:/weibo/fans/R/fansWords.R";
        rService.run(file, params);
    }

    @Override
    public void all(long uid) {
        gender(uid);
        wage(uid);
        verifer(uid);
        //fansCloud(uid);
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
