//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.fans.weibo.model.UserBirelateDTO;

/**
 * This is UserBirelate DAO interface
 * @author Conan Zhang
 * @date 2012-05-18
 */
public interface UserBirelateService extends SpringService {

    int insertUserBirelate(UserBirelateDTO dto);
    int updateUserBirelate(UserBirelateDTO dto);
    int saveUserBirelate(UserBirelateDTO dto);
    int saveUserBirelate(UserBirelateDTO dto, Map<String,Object> paramMap);
    int deleteUserBirelate(int id);
    int deleteUserBirelate(UserBirelateDTO dto);
    

    UserBirelateDTO getUserBirelateById(int id);
    UserBirelateDTO getUserBirelateOne(Map<String,Object> paramMap);
    List<UserBirelateDTO> getUserBirelates(Map<String,Object> paramMap);
    PageOutObject<UserBirelateDTO> getUserBirelatesPaging(Map<String,Object> paramMap, PageInObject page);
    int getUserBirelatesCount(Map<String,Object> paramMap);
}

