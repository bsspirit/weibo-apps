//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.fans.weibo.model.UserRelateDTO;

/**
 * This is UserRelate DAO interface
 * @author Conan Zhang
 * @date 2012-05-17
 */
public interface UserRelateDAO extends MybatisDAO {

    int insertUserRelate(UserRelateDTO dto);
    int updateUserRelate(UserRelateDTO dto);
    int deleteUserRelate(int id);
    int deleteUserRelates (UserRelateDTO dto);

    UserRelateDTO getUserRelateById(int id);
    UserRelateDTO getUserRelateOne(Map<String,Object> paramMap);
    List<UserRelateDTO> getUserRelates(Map<String,Object> paramMap);
    int getUserRelatesCount(Map<String,Object> paramMap);
}

