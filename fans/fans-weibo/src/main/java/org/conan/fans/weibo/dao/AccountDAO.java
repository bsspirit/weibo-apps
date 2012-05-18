//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.fans.weibo.model.AccountDTO;

/**
 * This is Account DAO interface
 * @author Conan Zhang
 * @date 2012-05-18
 */
public interface AccountDAO extends MybatisDAO {

    int insertAccount(AccountDTO dto);
    int updateAccount(AccountDTO dto);
    int deleteAccount(int id);
    int deleteAccounts (AccountDTO dto);

    AccountDTO getAccountById(int id);
    AccountDTO getAccountOne(Map<String,Object> paramMap);
    List<AccountDTO> getAccounts(Map<String,Object> paramMap);
    int getAccountsCount(Map<String,Object> paramMap);
}

