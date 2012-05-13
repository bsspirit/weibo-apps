//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.fans.weibo.model.UserRelateDTO;

/**
 * This is UserRelate DAO interface
 * @author Conan Zhang
 * @date 2012-05-13
 */
public interface UserRelateDAO extends MybatisDAO {

    int insertUserRelate(UserRelateDTO dto);
    int deleteUserRelate(int id);
    int updateUserRelate(UserRelateDTO dto);

    UserRelateDTO getUserRelateById(int id);
    List<UserRelateDTO> getUserRelates(Map<String,Object> paramMap);
    int getUserRelatesCount(Map<String,Object> paramMap);
}

