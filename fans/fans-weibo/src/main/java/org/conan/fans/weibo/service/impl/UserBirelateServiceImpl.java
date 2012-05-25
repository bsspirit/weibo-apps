//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.fans.weibo.dao.UserBirelateDAO;
import org.conan.fans.weibo.service.UserBirelateService;
import org.conan.fans.weibo.model.UserBirelateDTO;

/**
 * This is UserBirelate Service implemention
 * @author Conan Zhang
 * @date 2012-05-26
 */
@Service(value="userBirelateService")
public class UserBirelateServiceImpl extends SpringServiceImpl implements UserBirelateService {

    @Autowired
    UserBirelateDAO userBirelateDAO;

    public int insertUserBirelate(UserBirelateDTO dto) {
        return userBirelateDAO.insertUserBirelate(dto);
    }
    
    public int updateUserBirelate(UserBirelateDTO dto) {
        return userBirelateDAO.updateUserBirelate(dto);
    }
    
    public int saveUserBirelate(UserBirelateDTO dto) {
        if (dto.getId() > 0) {
            return updateUserBirelate(dto);
        }
        return insertUserBirelate(dto);
    }

    public int saveUserBirelate(UserBirelateDTO dto, Map<String, Object> paramMap) {
        UserBirelateDTO obj = getUserBirelateOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateUserBirelate(dto);
        }
         return insertUserBirelate(dto);
    }

    public int deleteUserBirelate(int id) {
        return userBirelateDAO.deleteUserBirelate(id);
    }

	public int deleteUserBirelate(UserBirelateDTO dto) {
        return userBirelateDAO.deleteUserBirelates(dto);
    }

    public UserBirelateDTO getUserBirelateById(int id) {
        return userBirelateDAO.getUserBirelateById(id);
    }
    
    public UserBirelateDTO getUserBirelateOne(Map<String, Object> paramMap) {
        return userBirelateDAO.getUserBirelateOne(paramMap);
    }

    public List<UserBirelateDTO> getUserBirelates(Map<String, Object> paramMap) {
        return userBirelateDAO.getUserBirelates(paramMap);
    }

    public PageOutObject<UserBirelateDTO> getUserBirelatesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<UserBirelateDTO> list = userBirelateDAO.getUserBirelates(paramMap);
        int count = userBirelateDAO.getUserBirelatesCount(paramMap);
        return new PageOutObject<UserBirelateDTO>(count, list, page);
    }
    
    public int getUserBirelatesCount(Map<String, Object> paramMap) {
        return userBirelateDAO.getUserBirelatesCount(paramMap);
    }

}
