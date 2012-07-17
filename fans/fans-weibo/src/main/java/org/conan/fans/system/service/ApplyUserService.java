//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.fans.system.model.ApplyUserDTO;

/**
 * This is ApplyUser DAO interface
 * @author Conan Zhang
 * @date 2012-07-17
 */
public interface ApplyUserService extends SpringService {

    int insertApplyUser(ApplyUserDTO dto);
    int updateApplyUser(ApplyUserDTO dto);
    int saveApplyUser(ApplyUserDTO dto);
    int saveApplyUser(ApplyUserDTO dto, Map<String,Object> paramMap);
    int deleteApplyUser(int id);
    int deleteApplyUser(ApplyUserDTO dto);
    

    ApplyUserDTO getApplyUserById(int id);
    ApplyUserDTO getApplyUserOne(Map<String,Object> paramMap);
    List<ApplyUserDTO> getApplyUsers(Map<String,Object> paramMap);
    PageOutObject<ApplyUserDTO> getApplyUsersPaging(Map<String,Object> paramMap, PageInObject page);
    int getApplyUsersCount(Map<String,Object> paramMap);
}

