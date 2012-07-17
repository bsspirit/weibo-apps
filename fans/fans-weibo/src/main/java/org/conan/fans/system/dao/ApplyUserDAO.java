//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.fans.system.model.ApplyUserDTO;

/**
 * This is ApplyUser DAO interface
 * @author Conan Zhang
 * @date 2012-07-17
 */
public interface ApplyUserDAO extends MybatisDAO {

    int insertApplyUser(ApplyUserDTO dto);
    int updateApplyUser(ApplyUserDTO dto);
    int deleteApplyUser(int id);
    int deleteApplyUsers (ApplyUserDTO dto);

    ApplyUserDTO getApplyUserById(int id);
    ApplyUserDTO getApplyUserOne(Map<String,Object> paramMap);
    List<ApplyUserDTO> getApplyUsers(Map<String,Object> paramMap);
    int getApplyUsersCount(Map<String,Object> paramMap);
}

