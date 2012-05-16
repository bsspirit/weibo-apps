//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.fans.weibo.model.UserRelateDTO;

/**
 * This is UserRelate DAO interface
 * @author Conan Zhang
 * @date 2012-05-17
 */
public interface UserRelateService extends SpringService {

    int insertUserRelate(UserRelateDTO dto);
    int updateUserRelate(UserRelateDTO dto);
    int updinsUserRelate(UserRelateDTO dto);
    int updinsUserRelate(UserRelateDTO dto, Map<String,Object> paramMap);
    int deleteUserRelate(int id);
    int deleteUserRelate(UserRelateDTO dto);
    

    UserRelateDTO getUserRelateById(int id);
    UserRelateDTO getUserRelateOne(Map<String,Object> paramMap);
    List<UserRelateDTO> getUserRelates(Map<String,Object> paramMap);
    PageOutObject<UserRelateDTO> getUserRelatesPaging(Map<String,Object> paramMap, PageInObject page);
    int getUserRelatesCount(Map<String,Object> paramMap);
}

