//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is Account Model DTO
 * @author Conan Zhang
 * @date 2012-05-16
 */
public class AccountDTO extends BaseObject {

private static final long serialVersionUID = 13371806617812L;

public AccountDTO(){}
public AccountDTO(Long uid, Timestamp create_date, String expireIn, String refresh, String token, String state){
this.uid = uid;
this.create_date = create_date;
this.expireIn = expireIn;
this.refresh = refresh;
this.token = token;
this.state = state;
}


private int id;
private Long uid;
private Timestamp create_date;
private String expireIn;
private String refresh;
private String token;
private String state;

public int getId() {
return this.id;
}

public Long getUid (){
return this.uid;
}
public Timestamp getCreate_date (){
return this.create_date;
}
public String getExpireIn (){
return this.expireIn;
}
public String getRefresh (){
return this.refresh;
}
public String getToken (){
return this.token;
}
public String getState (){
return this.state;
}


public void setId(int id) {
this.id = id;
}

public void setUid(Long uid) {
this.uid = uid;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}
public void setExpireIn(String expireIn) {
this.expireIn = expireIn;
}
public void setRefresh(String refresh) {
this.refresh = refresh;
}
public void setToken(String token) {
this.token = token;
}
public void setState(String state) {
this.state = state;
}


}
