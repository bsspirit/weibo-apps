//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.fans.weibo.model.UserIncreaseDTO;

/**
 * This is UserIncrease DAO interface
 * @author Conan Zhang
 * @date 2012-06-05
 */
public interface UserIncreaseDAO extends MybatisDAO {

    int insertUserIncrease(UserIncreaseDTO dto);
    int updateUserIncrease(UserIncreaseDTO dto);
    int deleteUserIncrease(int id);
    int deleteUserIncreases (UserIncreaseDTO dto);

    UserIncreaseDTO getUserIncreaseById(int id);
    UserIncreaseDTO getUserIncreaseOne(Map<String,Object> paramMap);
    List<UserIncreaseDTO> getUserIncreases(Map<String,Object> paramMap);
    int getUserIncreasesCount(Map<String,Object> paramMap);
}

