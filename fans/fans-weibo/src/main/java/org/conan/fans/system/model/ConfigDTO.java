//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.system.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is Config Model DTO
 * @author Conan Zhang
 * @date 2012-05-26
 */
public class ConfigDTO extends BaseObject {

private static final long serialVersionUID = 13379655553281L;

public ConfigDTO(){}
public ConfigDTO(Timestamp create_date, String imgUrl, String template, String type){
this.create_date = create_date;
this.imgUrl = imgUrl;
this.template = template;
this.type = type;
}


private int id;
private Timestamp create_date;
private String imgUrl;
private String template;
private String type;

public int getId() {
return this.id;
}

public Timestamp getCreate_date (){
return this.create_date;
}
public String getImgUrl (){
return this.imgUrl;
}
public String getTemplate (){
return this.template;
}
public String getType (){
return this.type;
}


public void setId(int id) {
this.id = id;
}

public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}
public void setImgUrl(String imgUrl) {
this.imgUrl = imgUrl;
}
public void setTemplate(String template) {
this.template = template;
}
public void setType(String type) {
this.type = type;
}


}
