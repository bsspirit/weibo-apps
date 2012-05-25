package org.conan.fans.service.util;

import java.util.HashMap;
import java.util.Map;

import org.conan.fans.weibo.model.AccountDTO;

import weibo4j.Oauth;

/**
 * ApplicationContext Cache Object
 * 
 * @author conan
 * 
 */
public class TokenMap {
    public static Map<Long, AccountDTO> tokenMaps = new HashMap<Long, AccountDTO>();
    public static Map<String, Oauth> oauthMaps = new HashMap<String, Oauth>();
    
}
