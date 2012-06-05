//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.model;

import org.conan.base.BaseObject;

/**
 * This is UserIncrease Model DTO
 * @author Conan Zhang
 * @date 2012-06-05
 */
public class UserIncreaseDTO extends BaseObject {

private static final long serialVersionUID = 13388615959932L;

public UserIncreaseDTO(){}
public UserIncreaseDTO(Long uid, Integer date, String type, Long count){
this.uid = uid;
this.date = date;
this.type = type;
this.count = count;
}


private int id;
private Long uid;
private Integer date;
private String type;
private Long count;

public int getId() {
return this.id;
}

public Long getUid (){
return this.uid;
}
public Integer getDate (){
return this.date;
}
public String getType (){
return this.type;
}
public Long getCount (){
return this.count;
}


public void setId(int id) {
this.id = id;
}

public void setUid(Long uid) {
this.uid = uid;
}
public void setDate(Integer date) {
this.date = date;
}
public void setType(String type) {
this.type = type;
}
public void setCount(Long count) {
this.count = count;
}


}
