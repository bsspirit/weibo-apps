//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.fans.weibo.dao.UserRelateDAO;
import org.conan.fans.weibo.service.UserRelateService;
import org.conan.fans.weibo.model.UserRelateDTO;

/**
 * This is UserRelate Service implemention
 * @author Conan Zhang
 * @date 2012-05-13
 */
@Service(value="userRelateService")
public class UserRelateServiceImpl extends SpringServiceImpl implements UserRelateService {

    @Autowired
    UserRelateDAO userRelateDAO;

    public int insertUserRelate(UserRelateDTO dto) {
        return userRelateDAO.insertUserRelate(dto);
    }

    public int deleteUserRelate(int id) {
        return userRelateDAO.deleteUserRelate(id);
    }

    public int updateUserRelate(UserRelateDTO dto) {
        return userRelateDAO.updateUserRelate(dto);
    }

    public UserRelateDTO getUserRelateById(int id) {
        return userRelateDAO.getUserRelateById(id);
    }

    public List<UserRelateDTO> getUserRelates(Map<String, Object> paramMap) {
        return userRelateDAO.getUserRelates(paramMap);
    }

    public PageOutObject<UserRelateDTO> getUserRelatesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<UserRelateDTO> list = userRelateDAO.getUserRelates(paramMap);
        int count = userRelateDAO.getUserRelatesCount(paramMap);
        return new PageOutObject<UserRelateDTO>(count, list, page);
    }
    
    public int getUserRelatesCount(Map<String, Object> paramMap) {
        return userRelateDAO.getUserRelatesCount(paramMap);
    }

}
