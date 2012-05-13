//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.fans.weibo.model;

import java.util.Date;
import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is User Model DTO
 * @author Conan Zhang
 * @date 2012-05-13
 */
public class UserDTO extends BaseObject {

private static final long serialVersionUID = 13369148080931L;

public UserDTO(){}
public UserDTO(Long uid, String screen_name, String name, Integer province, Integer city, String location, String description, String url, String profile_image_url, String domain, String gender, Integer followers_count, Integer friends_count, Integer statuses_count, Integer favourites_count, Date created_at, String following, String allow_all_act_msg, String remark, String geo_enabled, String verified, String allow_all_comment, String avatar_large, String verified_reason, String follow_me, Integer online_status, Integer bi_followers_count, String lang, String weihao, Integer verifiedType, Timestamp create_date){
this.uid = uid;
this.screen_name = screen_name;
this.name = name;
this.province = province;
this.city = city;
this.location = location;
this.description = description;
this.url = url;
this.profile_image_url = profile_image_url;
this.domain = domain;
this.gender = gender;
this.followers_count = followers_count;
this.friends_count = friends_count;
this.statuses_count = statuses_count;
this.favourites_count = favourites_count;
this.created_at = created_at;
this.following = following;
this.allow_all_act_msg = allow_all_act_msg;
this.remark = remark;
this.geo_enabled = geo_enabled;
this.verified = verified;
this.allow_all_comment = allow_all_comment;
this.avatar_large = avatar_large;
this.verified_reason = verified_reason;
this.follow_me = follow_me;
this.online_status = online_status;
this.bi_followers_count = bi_followers_count;
this.lang = lang;
this.weihao = weihao;
this.verifiedType = verifiedType;
this.create_date = create_date;
}


private int id;
private Long uid;
private String screen_name;
private String name;
private Integer province;
private Integer city;
private String location;
private String description;
private String url;
private String profile_image_url;
private String domain;
private String gender;
private Integer followers_count;
private Integer friends_count;
private Integer statuses_count;
private Integer favourites_count;
private Date created_at;
private String following;
private String allow_all_act_msg;
private String remark;
private String geo_enabled;
private String verified;
private String allow_all_comment;
private String avatar_large;
private String verified_reason;
private String follow_me;
private Integer online_status;
private Integer bi_followers_count;
private String lang;
private String weihao;
private Integer verifiedType;
private Timestamp create_date;

public int getId() {
return this.id;
}

public Long getUid (){
return this.uid;
}
public String getScreen_name (){
return this.screen_name;
}
public String getName (){
return this.name;
}
public Integer getProvince (){
return this.province;
}
public Integer getCity (){
return this.city;
}
public String getLocation (){
return this.location;
}
public String getDescription (){
return this.description;
}
public String getUrl (){
return this.url;
}
public String getProfile_image_url (){
return this.profile_image_url;
}
public String getDomain (){
return this.domain;
}
public String getGender (){
return this.gender;
}
public Integer getFollowers_count (){
return this.followers_count;
}
public Integer getFriends_count (){
return this.friends_count;
}
public Integer getStatuses_count (){
return this.statuses_count;
}
public Integer getFavourites_count (){
return this.favourites_count;
}
public Date getCreated_at (){
return this.created_at;
}
public String getFollowing (){
return this.following;
}
public String getAllow_all_act_msg (){
return this.allow_all_act_msg;
}
public String getRemark (){
return this.remark;
}
public String getGeo_enabled (){
return this.geo_enabled;
}
public String getVerified (){
return this.verified;
}
public String getAllow_all_comment (){
return this.allow_all_comment;
}
public String getAvatar_large (){
return this.avatar_large;
}
public String getVerified_reason (){
return this.verified_reason;
}
public String getFollow_me (){
return this.follow_me;
}
public Integer getOnline_status (){
return this.online_status;
}
public Integer getBi_followers_count (){
return this.bi_followers_count;
}
public String getLang (){
return this.lang;
}
public String getWeihao (){
return this.weihao;
}
public Integer getVerifiedType (){
return this.verifiedType;
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
public void setScreen_name(String screen_name) {
this.screen_name = screen_name;
}
public void setName(String name) {
this.name = name;
}
public void setProvince(Integer province) {
this.province = province;
}
public void setCity(Integer city) {
this.city = city;
}
public void setLocation(String location) {
this.location = location;
}
public void setDescription(String description) {
this.description = description;
}
public void setUrl(String url) {
this.url = url;
}
public void setProfile_image_url(String profile_image_url) {
this.profile_image_url = profile_image_url;
}
public void setDomain(String domain) {
this.domain = domain;
}
public void setGender(String gender) {
this.gender = gender;
}
public void setFollowers_count(Integer followers_count) {
this.followers_count = followers_count;
}
public void setFriends_count(Integer friends_count) {
this.friends_count = friends_count;
}
public void setStatuses_count(Integer statuses_count) {
this.statuses_count = statuses_count;
}
public void setFavourites_count(Integer favourites_count) {
this.favourites_count = favourites_count;
}
public void setCreated_at(Date created_at) {
this.created_at = created_at;
}
public void setFollowing(String following) {
this.following = following;
}
public void setAllow_all_act_msg(String allow_all_act_msg) {
this.allow_all_act_msg = allow_all_act_msg;
}
public void setRemark(String remark) {
this.remark = remark;
}
public void setGeo_enabled(String geo_enabled) {
this.geo_enabled = geo_enabled;
}
public void setVerified(String verified) {
this.verified = verified;
}
public void setAllow_all_comment(String allow_all_comment) {
this.allow_all_comment = allow_all_comment;
}
public void setAvatar_large(String avatar_large) {
this.avatar_large = avatar_large;
}
public void setVerified_reason(String verified_reason) {
this.verified_reason = verified_reason;
}
public void setFollow_me(String follow_me) {
this.follow_me = follow_me;
}
public void setOnline_status(Integer online_status) {
this.online_status = online_status;
}
public void setBi_followers_count(Integer bi_followers_count) {
this.bi_followers_count = bi_followers_count;
}
public void setLang(String lang) {
this.lang = lang;
}
public void setWeihao(String weihao) {
this.weihao = weihao;
}
public void setVerifiedType(Integer verifiedType) {
this.verifiedType = verifiedType;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
