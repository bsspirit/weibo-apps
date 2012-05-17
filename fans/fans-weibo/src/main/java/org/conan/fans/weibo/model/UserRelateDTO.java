//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is UserRelate Model DTO
 * @author Conan Zhang
 * @date 2012-05-17
 */
public class UserRelateDTO extends BaseObject {

private static final long serialVersionUID = 13372235392262L;

public UserRelateDTO(){}
public UserRelateDTO(Long uid, Long fansid, Timestamp create_date){
this.uid = uid;
this.fansid = fansid;
this.create_date = create_date;
}


private int id;
private Long uid;
private Long fansid;
private Timestamp create_date;

public int getId() {
return this.id;
}

public Long getUid (){
return this.uid;
}
public Long getFansid (){
return this.fansid;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setUid(Long uid) {
this.uid = uid;
}
public void setFansid(Long fansid) {
this.fansid = fansid;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
