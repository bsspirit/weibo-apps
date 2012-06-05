//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service.impl;

import java.util.List;
import java.util.Map;

import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;
import org.conan.base.service.SpringServiceImpl;
import org.conan.base.util.MyDate;
import org.conan.fans.weibo.dao.UserIncreaseDAO;
import org.conan.fans.weibo.model.UserIncreaseDTO;
import org.conan.fans.weibo.service.UserIncreaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.model.User;

/**
 * This is UserIncrease Service implemention
 * 
 * @author Conan Zhang
 * @date 2012-06-05
 */
@Service(value = "userIncreaseService")
public class UserIncreaseServiceImpl extends SpringServiceImpl implements UserIncreaseService {
    
    @Autowired
    UserIncreaseDAO userIncreaseDAO;
    
    public int insertUserIncrease(UserIncreaseDTO dto) {
        return userIncreaseDAO.insertUserIncrease(dto);
    }
    
    public int updateUserIncrease(UserIncreaseDTO dto) {
        return userIncreaseDAO.updateUserIncrease(dto);
    }
    
    public int saveUserIncrease(UserIncreaseDTO dto) {
        if (dto.getId() > 0) {
            return updateUserIncrease(dto);
        }
        return insertUserIncrease(dto);
    }
    
    public int saveUserIncrease(UserIncreaseDTO dto, Map<String, Object> paramMap) {
        UserIncreaseDTO obj = getUserIncreaseOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateUserIncrease(dto);
        }
        return insertUserIncrease(dto);
    }
    
    public int deleteUserIncrease(int id) {
        return userIncreaseDAO.deleteUserIncrease(id);
    }
    
    public int deleteUserIncrease(UserIncreaseDTO dto) {
        return userIncreaseDAO.deleteUserIncreases(dto);
    }
    
    public UserIncreaseDTO getUserIncreaseById(int id) {
        return userIncreaseDAO.getUserIncreaseById(id);
    }
    
    public UserIncreaseDTO getUserIncreaseOne(Map<String, Object> paramMap) {
        return userIncreaseDAO.getUserIncreaseOne(paramMap);
    }
    
    public List<UserIncreaseDTO> getUserIncreases(Map<String, Object> paramMap) {
        return userIncreaseDAO.getUserIncreases(paramMap);
    }
    
    public PageOutObject<UserIncreaseDTO> getUserIncreasesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<UserIncreaseDTO> list = userIncreaseDAO.getUserIncreases(paramMap);
        int count = userIncreaseDAO.getUserIncreasesCount(paramMap);
        return new PageOutObject<UserIncreaseDTO>(count, list, page);
    }
    
    public int getUserIncreasesCount(Map<String, Object> paramMap) {
        return userIncreaseDAO.getUserIncreasesCount(paramMap);
    }
    
    // =============================
    public void userIncrease(long uid, User user) {// 保存用户增长
        int today = MyDate.dateInt(MyDate.getNow());
        deleteUserIncrease(new UserIncreaseDTO(uid, today, null, null));
        insertUserIncrease(new UserIncreaseDTO(uid, today, SpringService.INCREASE_FANS, (long) user.getFollowersCount()));
        insertUserIncrease(new UserIncreaseDTO(uid, today, SpringService.INCREASE_FRIENDS, (long) user.getFriendsCount()));
        insertUserIncrease(new UserIncreaseDTO(uid, today, SpringService.INCREASE_STATUS, (long) user.getStatusesCount()));
    }
    
}
