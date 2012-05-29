package org.conan.fans.service;

/**
 * 微博数据分析，调用R语言
 * 
 * @author Conan
 * 
 */
public interface WeiboReportService extends WeiboService{
    
    void all(long uid);
    void gender(long uid);
    void wage(long uid);
    void verifer(long uid);
    void cloud(long uid);
    void face(long uid);

}
