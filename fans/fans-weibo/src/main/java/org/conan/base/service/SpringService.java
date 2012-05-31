package org.conan.base.service;

/**
 * Conan
 */
public interface SpringService {
    
    // 服务名字
    String REST_GENDER = "rest.gender";
    String REST_WAGE = "rest.wage";
    String REST_VERIFER = "rest.verifer";
    String REST_CLOUD = "rest.cloud";
    String REST_FACE = "rest.face";
    
    // 访问限制
    String LIMIT_REPORT_FANS = "report.fans";
    String LIMIT_WEIBO_LOAD_FANS = "weibo.load.fans";
    
    // 时间常量
    long TIME_SECOND = 1;
    long TIME_MINUTE = TIME_SECOND * 60;
    long TIME_HOUR = TIME_MINUTE * 60;
    long TIME_DAY = TIME_HOUR * 24;
    
}
