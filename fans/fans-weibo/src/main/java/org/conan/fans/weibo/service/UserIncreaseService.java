//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.fans.weibo.model.UserIncreaseDTO;

import weibo4j.model.User;

/**
 * This is UserIncrease DAO interface
 * @author Conan Zhang
 * @date 2012-06-05
 */
public interface UserIncreaseService extends SpringService {

    int insertUserIncrease(UserIncreaseDTO dto);
    int updateUserIncrease(UserIncreaseDTO dto);
    int saveUserIncrease(UserIncreaseDTO dto);
    int saveUserIncrease(UserIncreaseDTO dto, Map<String,Object> paramMap);
    int deleteUserIncrease(int id);
    int deleteUserIncrease(UserIncreaseDTO dto);
    

    UserIncreaseDTO getUserIncreaseById(int id);
    UserIncreaseDTO getUserIncreaseOne(Map<String,Object> paramMap);
    List<UserIncreaseDTO> getUserIncreases(Map<String,Object> paramMap);
    PageOutObject<UserIncreaseDTO> getUserIncreasesPaging(Map<String,Object> paramMap, PageInObject page);
    int getUserIncreasesCount(Map<String,Object> paramMap);
    
    /**
     * 用户增长
     */
    void userIncrease(long uid, User user);
}

