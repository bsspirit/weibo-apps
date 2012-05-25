//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is UserBirelate Model DTO
 * @author Conan Zhang
 * @date 2012-05-26
 */
public class UserBirelateDTO extends BaseObject {

private static final long serialVersionUID = 13379652879532L;

public UserBirelateDTO(){}
public UserBirelateDTO(Long uid, Long biuid, Timestamp create_date){
this.uid = uid;
this.biuid = biuid;
this.create_date = create_date;
}


private int id;
private Long uid;
private Long biuid;
private Timestamp create_date;

public int getId() {
return this.id;
}

public Long getUid (){
return this.uid;
}
public Long getBiuid (){
return this.biuid;
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
public void setBiuid(Long biuid) {
this.biuid = biuid;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
