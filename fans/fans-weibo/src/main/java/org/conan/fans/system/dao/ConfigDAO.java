//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.fans.system.model.ConfigDTO;

/**
 * This is Config DAO interface
 * @author Conan Zhang
 * @date 2012-05-26
 */
public interface ConfigDAO extends MybatisDAO {

    int insertConfig(ConfigDTO dto);
    int updateConfig(ConfigDTO dto);
    int deleteConfig(int id);
    int deleteConfigs (ConfigDTO dto);

    ConfigDTO getConfigById(int id);
    ConfigDTO getConfigOne(Map<String,Object> paramMap);
    List<ConfigDTO> getConfigs(Map<String,Object> paramMap);
    int getConfigsCount(Map<String,Object> paramMap);
}

