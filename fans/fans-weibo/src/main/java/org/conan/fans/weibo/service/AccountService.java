//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.fans.weibo.model.AccountDTO;

/**
 * This is Account DAO interface
 * @author Conan Zhang
 * @date 2012-05-16
 */
public interface AccountService extends SpringService {

    int insertAccount(AccountDTO dto);
    int updateAccount(AccountDTO dto);
    int deleteAccount(int id);
    int deleteAccount(AccountDTO dto);
    

    AccountDTO getAccountById(int id);
    List<AccountDTO> getAccounts(Map<String,Object> paramMap);
    PageOutObject<AccountDTO> getAccountsPaging(Map<String,Object> paramMap, PageInObject page);
    int getAccountsCount(Map<String,Object> paramMap);
}

