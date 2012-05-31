//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.fans.system.model.LimitUserDTO;

/**
 * This is LimitUser DAO interface
 * @author Conan Zhang
 * @date 2012-05-31
 */
public interface LimitUserDAO extends MybatisDAO {

    int insertLimitUser(LimitUserDTO dto);
    int updateLimitUser(LimitUserDTO dto);
    int deleteLimitUser(int id);
    int deleteLimitUsers (LimitUserDTO dto);

    LimitUserDTO getLimitUserById(int id);
    LimitUserDTO getLimitUserOne(Map<String,Object> paramMap);
    List<LimitUserDTO> getLimitUsers(Map<String,Object> paramMap);
    int getLimitUsersCount(Map<String,Object> paramMap);
}

