//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.fans.weibo.model.ProvincesDTO;

/**
 * This is Provinces DAO interface
 * @author Conan Zhang
 * @date 2012-06-06
 */
public interface ProvincesService extends SpringService {

    int insertProvinces(ProvincesDTO dto);
    int updateProvinces(ProvincesDTO dto);
    int saveProvinces(ProvincesDTO dto);
    int saveProvinces(ProvincesDTO dto, Map<String,Object> paramMap);
    int deleteProvinces(int id);
    int deleteProvinces(ProvincesDTO dto);
    

    ProvincesDTO getProvincesById(int id);
    ProvincesDTO getProvincesOne(Map<String,Object> paramMap);
    List<ProvincesDTO> getProvincess(Map<String,Object> paramMap);
    PageOutObject<ProvincesDTO> getProvincessPaging(Map<String,Object> paramMap, PageInObject page);
    int getProvincessCount(Map<String,Object> paramMap);
}

