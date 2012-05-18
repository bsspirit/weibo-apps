//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.fans.weibo.dao.AccountDAO;
import org.conan.fans.weibo.service.AccountService;
import org.conan.fans.weibo.model.AccountDTO;

/**
 * This is Account Service implemention
 * @author Conan Zhang
 * @date 2012-05-18
 */
@Service(value="accountService")
public class AccountServiceImpl extends SpringServiceImpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    public int insertAccount(AccountDTO dto) {
        return accountDAO.insertAccount(dto);
    }
    
    public int updateAccount(AccountDTO dto) {
        return accountDAO.updateAccount(dto);
    }
    
    public int saveAccount(AccountDTO dto) {
        if (dto.getId() > 0) {
            return updateAccount(dto);
        }
        return insertAccount(dto);
    }

    public int saveAccount(AccountDTO dto, Map<String, Object> paramMap) {
        AccountDTO obj = getAccountOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateAccount(dto);
        }
         return insertAccount(dto);
    }

    public int deleteAccount(int id) {
        return accountDAO.deleteAccount(id);
    }

	public int deleteAccount(AccountDTO dto) {
        return accountDAO.deleteAccounts(dto);
    }

    public AccountDTO getAccountById(int id) {
        return accountDAO.getAccountById(id);
    }
    
    public AccountDTO getAccountOne(Map<String, Object> paramMap) {
        return accountDAO.getAccountOne(paramMap);
    }

    public List<AccountDTO> getAccounts(Map<String, Object> paramMap) {
        return accountDAO.getAccounts(paramMap);
    }

    public PageOutObject<AccountDTO> getAccountsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<AccountDTO> list = accountDAO.getAccounts(paramMap);
        int count = accountDAO.getAccountsCount(paramMap);
        return new PageOutObject<AccountDTO>(count, list, page);
    }
    
    public int getAccountsCount(Map<String, Object> paramMap) {
        return accountDAO.getAccountsCount(paramMap);
    }

}
