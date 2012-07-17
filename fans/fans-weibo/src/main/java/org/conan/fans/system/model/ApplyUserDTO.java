//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is ApplyUser Model DTO
 * @author Conan Zhang
 * @date 2012-07-17
 */
public class ApplyUserDTO extends BaseObject {

private static final long serialVersionUID = 13425025250682L;

public ApplyUserDTO(){}
public ApplyUserDTO(Long uid, String name, Timestamp create_date){
this.uid = uid;
this.name = name;
this.create_date = create_date;
}


private int id;
private Long uid;
private String name;
private Timestamp create_date;

public int getId() {
return this.id;
}

public Long getUid (){
return this.uid;
}
public String getName (){
return this.name;
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
public void setName(String name) {
this.name = name;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
