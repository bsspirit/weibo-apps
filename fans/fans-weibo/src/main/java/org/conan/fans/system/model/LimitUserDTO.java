//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is LimitUser Model DTO
 * @author Conan Zhang
 * @date 2012-05-31
 */
public class LimitUserDTO extends BaseObject {

private static final long serialVersionUID = 13384369347461L;

public LimitUserDTO(){}
public LimitUserDTO(Long uid, String name, Long limit_time, Timestamp create_date){
this.uid = uid;
this.name = name;
this.limit_time = limit_time;
this.create_date = create_date;
}


private int id;
private Long uid;
private String name;
private Long limit_time;
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
public Long getLimit_time (){
return this.limit_time;
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
public void setLimit_time(Long limit_time) {
this.limit_time = limit_time;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
