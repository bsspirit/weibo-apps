//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.fans.weibo.dao.ProvincesDAO;
import org.conan.fans.weibo.service.ProvincesService;
import org.conan.fans.weibo.model.ProvincesDTO;

/**
 * This is Provinces Service implemention
 * @author Conan Zhang
 * @date 2012-06-06
 */
@Service(value="provincesService")
public class ProvincesServiceImpl extends SpringServiceImpl implements ProvincesService {

    @Autowired
    ProvincesDAO provincesDAO;

    public int insertProvinces(ProvincesDTO dto) {
        return provincesDAO.insertProvinces(dto);
    }
    
    public int updateProvinces(ProvincesDTO dto) {
        return provincesDAO.updateProvinces(dto);
    }
    
    public int saveProvinces(ProvincesDTO dto) {
        if (dto.getId() > 0) {
            return updateProvinces(dto);
        }
        return insertProvinces(dto);
    }

    public int saveProvinces(ProvincesDTO dto, Map<String, Object> paramMap) {
        ProvincesDTO obj = getProvincesOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateProvinces(dto);
        }
         return insertProvinces(dto);
    }

    public int deleteProvinces(int id) {
        return provincesDAO.deleteProvinces(id);
    }

	public int deleteProvinces(ProvincesDTO dto) {
        return provincesDAO.deleteProvincess(dto);
    }

    public ProvincesDTO getProvincesById(int id) {
        return provincesDAO.getProvincesById(id);
    }
    
    public ProvincesDTO getProvincesOne(Map<String, Object> paramMap) {
        return provincesDAO.getProvincesOne(paramMap);
    }

    public List<ProvincesDTO> getProvincess(Map<String, Object> paramMap) {
        return provincesDAO.getProvincess(paramMap);
    }

    public PageOutObject<ProvincesDTO> getProvincessPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<ProvincesDTO> list = provincesDAO.getProvincess(paramMap);
        int count = provincesDAO.getProvincessCount(paramMap);
        return new PageOutObject<ProvincesDTO>(count, list, page);
    }
    
    public int getProvincessCount(Map<String, Object> paramMap) {
        return provincesDAO.getProvincessCount(paramMap);
    }

}
