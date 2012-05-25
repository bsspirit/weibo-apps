//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.fans.weibo.model.UserBirelateDTO;

/**
 * This is UserBirelate DAO interface
 * @author Conan Zhang
 * @date 2012-05-26
 */
public interface UserBirelateDAO extends MybatisDAO {

    int insertUserBirelate(UserBirelateDTO dto);
    int updateUserBirelate(UserBirelateDTO dto);
    int deleteUserBirelate(int id);
    int deleteUserBirelates (UserBirelateDTO dto);

    UserBirelateDTO getUserBirelateById(int id);
    UserBirelateDTO getUserBirelateOne(Map<String,Object> paramMap);
    List<UserBirelateDTO> getUserBirelates(Map<String,Object> paramMap);
    int getUserBirelatesCount(Map<String,Object> paramMap);
}

