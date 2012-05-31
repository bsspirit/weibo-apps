//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.fans.system.model.LimitUserDTO;

/**
 * This is LimitUser DAO interface
 * @author Conan Zhang
 * @date 2012-05-31
 */
public interface LimitUserService extends SpringService {

    int insertLimitUser(LimitUserDTO dto);
    int updateLimitUser(LimitUserDTO dto);
    int saveLimitUser(LimitUserDTO dto);
    int saveLimitUser(LimitUserDTO dto, Map<String,Object> paramMap);
    int deleteLimitUser(int id);
    int deleteLimitUser(LimitUserDTO dto);
    

    LimitUserDTO getLimitUserById(int id);
    LimitUserDTO getLimitUserOne(Map<String,Object> paramMap);
    List<LimitUserDTO> getLimitUsers(Map<String,Object> paramMap);
    PageOutObject<LimitUserDTO> getLimitUsersPaging(Map<String,Object> paramMap, PageInObject page);
    int getLimitUsersCount(Map<String,Object> paramMap);
}

