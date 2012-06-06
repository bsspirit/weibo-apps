//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.model;

import org.conan.base.BaseObject;

/**
 * This is Provinces Model DTO
 * @author Conan Zhang
 * @date 2012-06-06
 */
public class ProvincesDTO extends BaseObject {

private static final long serialVersionUID = 13389759227881L;

public ProvincesDTO(){}
public ProvincesDTO(String name, Integer pid, Integer cid, String longitude, String latitude){
this.name = name;
this.pid = pid;
this.cid = cid;
this.longitude = longitude;
this.latitude = latitude;
}


private int id;
private String name;
private Integer pid;
private Integer cid;
private String longitude;
private String latitude;

public int getId() {
return this.id;
}

public String getName (){
return this.name;
}
public Integer getPid (){
return this.pid;
}
public Integer getCid (){
return this.cid;
}
public String getLongitude (){
return this.longitude;
}
public String getLatitude (){
return this.latitude;
}


public void setId(int id) {
this.id = id;
}

public void setName(String name) {
this.name = name;
}
public void setPid(Integer pid) {
this.pid = pid;
}
public void setCid(Integer cid) {
this.cid = cid;
}
public void setLongitude(String longitude) {
this.longitude = longitude;
}
public void setLatitude(String latitude) {
this.latitude = latitude;
}


}
