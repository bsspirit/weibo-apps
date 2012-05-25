//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.web.form;

import org.conan.fans.weibo.model.UserDTO;

/**
 * This is UserForm Form Model
 * @author Conan Zhang
 * @date 2012-05-26
 */
public class UserForm extends UserDTO {

private static final long serialVersionUID = 13379641606562L;

public UserForm(){}
public UserForm(UserDTO dto){
super.setId(dto.getId());
super.setUid(dto.getUid());
super.setScreen_name(dto.getScreen_name());
super.setName(dto.getName());
super.setProvince(dto.getProvince());
super.setCity(dto.getCity());
super.setLocation(dto.getLocation());
super.setDescription(dto.getDescription());
super.setUrl(dto.getUrl());
super.setProfile_image_url(dto.getProfile_image_url());
super.setDomain(dto.getDomain());
super.setGender(dto.getGender());
super.setFollowers_count(dto.getFollowers_count());
super.setFriends_count(dto.getFriends_count());
super.setStatuses_count(dto.getStatuses_count());
super.setFavourites_count(dto.getFavourites_count());
super.setCreated_at(dto.getCreated_at());
super.setAllow_all_act_msg(dto.getAllow_all_act_msg());
super.setRemark(dto.getRemark());
super.setGeo_enabled(dto.getGeo_enabled());
super.setVerified(dto.getVerified());
super.setAllow_all_comment(dto.getAllow_all_comment());
super.setAvatar_large(dto.getAvatar_large());
super.setVerified_reason(dto.getVerified_reason());
super.setOnline_status(dto.getOnline_status());
super.setLang(dto.getLang());
super.setWeihao(dto.getWeihao());
super.setVerifiedType(dto.getVerifiedType());
super.setCreate_date(dto.getCreate_date());
}


}
