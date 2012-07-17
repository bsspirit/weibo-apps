//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.fans.system.dao.ApplyUserDAO;
import org.conan.fans.system.service.ApplyUserService;
import org.conan.fans.system.model.ApplyUserDTO;

/**
 * This is ApplyUser Service implemention
 * @author Conan Zhang
 * @date 2012-07-17
 */
@Service(value="applyUserService")
public class ApplyUserServiceImpl extends SpringServiceImpl implements ApplyUserService {

    @Autowired
    ApplyUserDAO applyUserDAO;

    public int insertApplyUser(ApplyUserDTO dto) {
        return applyUserDAO.insertApplyUser(dto);
    }
    
    public int updateApplyUser(ApplyUserDTO dto) {
        return applyUserDAO.updateApplyUser(dto);
    }
    
    public int saveApplyUser(ApplyUserDTO dto) {
        if (dto.getId() > 0) {
            return updateApplyUser(dto);
        }
        return insertApplyUser(dto);
    }

    public int saveApplyUser(ApplyUserDTO dto, Map<String, Object> paramMap) {
        ApplyUserDTO obj = getApplyUserOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateApplyUser(dto);
        }
         return insertApplyUser(dto);
    }

    public int deleteApplyUser(int id) {
        return applyUserDAO.deleteApplyUser(id);
    }

	public int deleteApplyUser(ApplyUserDTO dto) {
        return applyUserDAO.deleteApplyUsers(dto);
    }

    public ApplyUserDTO getApplyUserById(int id) {
        return applyUserDAO.getApplyUserById(id);
    }
    
    public ApplyUserDTO getApplyUserOne(Map<String, Object> paramMap) {
        return applyUserDAO.getApplyUserOne(paramMap);
    }

    public List<ApplyUserDTO> getApplyUsers(Map<String, Object> paramMap) {
        return applyUserDAO.getApplyUsers(paramMap);
    }

    public PageOutObject<ApplyUserDTO> getApplyUsersPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<ApplyUserDTO> list = applyUserDAO.getApplyUsers(paramMap);
        int count = applyUserDAO.getApplyUsersCount(paramMap);
        return new PageOutObject<ApplyUserDTO>(count, list, page);
    }
    
    public int getApplyUsersCount(Map<String, Object> paramMap) {
        return applyUserDAO.getApplyUsersCount(paramMap);
    }

}
