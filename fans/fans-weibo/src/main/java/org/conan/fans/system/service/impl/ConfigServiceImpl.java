//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.fans.system.dao.ConfigDAO;
import org.conan.fans.system.service.ConfigService;
import org.conan.fans.system.model.ConfigDTO;

/**
 * This is Config Service implemention
 * @author Conan Zhang
 * @date 2012-05-26
 */
@Service(value="configService")
public class ConfigServiceImpl extends SpringServiceImpl implements ConfigService {

    @Autowired
    ConfigDAO configDAO;

    public int insertConfig(ConfigDTO dto) {
        return configDAO.insertConfig(dto);
    }
    
    public int updateConfig(ConfigDTO dto) {
        return configDAO.updateConfig(dto);
    }
    
    public int saveConfig(ConfigDTO dto) {
        if (dto.getId() > 0) {
            return updateConfig(dto);
        }
        return insertConfig(dto);
    }

    public int saveConfig(ConfigDTO dto, Map<String, Object> paramMap) {
        ConfigDTO obj = getConfigOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateConfig(dto);
        }
         return insertConfig(dto);
    }

    public int deleteConfig(int id) {
        return configDAO.deleteConfig(id);
    }

	public int deleteConfig(ConfigDTO dto) {
        return configDAO.deleteConfigs(dto);
    }

    public ConfigDTO getConfigById(int id) {
        return configDAO.getConfigById(id);
    }
    
    public ConfigDTO getConfigOne(Map<String, Object> paramMap) {
        return configDAO.getConfigOne(paramMap);
    }

    public List<ConfigDTO> getConfigs(Map<String, Object> paramMap) {
        return configDAO.getConfigs(paramMap);
    }

    public PageOutObject<ConfigDTO> getConfigsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<ConfigDTO> list = configDAO.getConfigs(paramMap);
        int count = configDAO.getConfigsCount(paramMap);
        return new PageOutObject<ConfigDTO>(count, list, page);
    }
    
    public int getConfigsCount(Map<String, Object> paramMap) {
        return configDAO.getConfigsCount(paramMap);
    }

}
