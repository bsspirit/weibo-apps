//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.model;

import org.conan.base.BaseObject;

/**
 * This is Provinces Model DTO
 * @author Conan Zhang
 * @date 2012-05-16
 */
public class ProvincesDTO extends BaseObject {

private static final long serialVersionUID = 13371806618120L;

public ProvincesDTO(){}
public ProvincesDTO(String name){
this.name = name;
}


private int id;
private String name;

public int getId() {
return this.id;
}

public String getName (){
return this.name;
}


public void setId(int id) {
this.id = id;
}

public void setName(String name) {
this.name = name;
}


}
