//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is Account Model DTO
 * @author Conan Zhang
 * @date 2012-05-26
 */
public class AccountDTO extends BaseObject {

private static final long serialVersionUID = 13379652879370L;

public AccountDTO(){}
public AccountDTO(Long uid, Timestamp create_date, String expireIn, String refresh, String state, String screen_name, String token){
this.uid = uid;
this.create_date = create_date;
this.expireIn = expireIn;
this.refresh = refresh;
this.state = state;
this.screen_name = screen_name;
this.token = token;
}


private int id;
private Long uid;
private Timestamp create_date;
private String expireIn;
private String refresh;
private String state;
private String screen_name;
private String token;

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
public String getState (){
return this.state;
}
public String getScreen_name (){
return this.screen_name;
}
public String getToken (){
return this.token;
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
public void setState(String state) {
this.state = state;
}
public void setScreen_name(String screen_name) {
this.screen_name = screen_name;
}
public void setToken(String token) {
this.token = token;
}


}
