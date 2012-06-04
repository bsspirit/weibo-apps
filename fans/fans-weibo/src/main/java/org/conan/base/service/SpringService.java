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

    // 微博读取数量
    int WEIBO_LOAD_COUNT_200 = 200;
    int WEIBO_LOAD_COUNT_2000 = 2000;
    int WEIBO_LOAD_COUNT_5000 = 5000;
    int WEIBO_LOAD_CURSOR = 0;

}
