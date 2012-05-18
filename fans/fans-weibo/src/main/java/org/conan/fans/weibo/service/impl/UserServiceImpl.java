//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.fans.weibo.dao.UserDAO;
import org.conan.fans.weibo.service.UserService;
import org.conan.fans.weibo.model.UserDTO;

/**
 * This is User Service implemention
 * @author Conan Zhang
 * @date 2012-05-18
 */
@Service(value="userService")
public class UserServiceImpl extends SpringServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    public int insertUser(UserDTO dto) {
        return userDAO.insertUser(dto);
    }
    
    public int updateUser(UserDTO dto) {
        return userDAO.updateUser(dto);
    }
    
    public int saveUser(UserDTO dto) {
        if (dto.getId() > 0) {
            return updateUser(dto);
        }
        return insertUser(dto);
    }

    public int saveUser(UserDTO dto, Map<String, Object> paramMap) {
        UserDTO obj = getUserOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateUser(dto);
        }
         return insertUser(dto);
    }

    public int deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

	public int deleteUser(UserDTO dto) {
        return userDAO.deleteUsers(dto);
    }

    public UserDTO getUserById(int id) {
        return userDAO.getUserById(id);
    }
    
    public UserDTO getUserOne(Map<String, Object> paramMap) {
        return userDAO.getUserOne(paramMap);
    }

    public List<UserDTO> getUsers(Map<String, Object> paramMap) {
        return userDAO.getUsers(paramMap);
    }

    public PageOutObject<UserDTO> getUsersPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<UserDTO> list = userDAO.getUsers(paramMap);
        int count = userDAO.getUsersCount(paramMap);
        return new PageOutObject<UserDTO>(count, list, page);
    }
    
    public int getUsersCount(Map<String, Object> paramMap) {
        return userDAO.getUsersCount(paramMap);
    }

}
