package org.conan.fans.service.util;

import org.conan.fans.weibo.model.UserDTO;

import weibo4j.model.User;

/**
 * 微博数据模型转换
 * 
 * @author Conan
 * 
 */
public class WeiboTransfer {

    public static UserDTO user(User u) {
        UserDTO dto = new UserDTO();
        dto.setUid(Long.parseLong(u.getId()));
        dto.setScreen_name(u.getScreenName());
        dto.setName(u.getName());
        dto.setProvince(u.getProvince());
        dto.setCity(u.getCity());
        dto.setLocation(u.getLocation());
        dto.setDescription(u.getDescription());
        dto.setUrl(u.getUrl());
        dto.setProfile_image_url(u.getProfileImageUrl());
        dto.setDomain(u.getUserDomain());
        dto.setGender(u.getGender());
        dto.setFollowers_count(u.getFollowersCount());
        dto.setFriends_count(u.getFriendsCount());
        dto.setStatuses_count(u.getStatusesCount());
        dto.setFavourites_count(u.getFavouritesCount());
        dto.setCreated_at(u.getCreatedAt());
        dto.setVerified(u.isVerified() ? "t" : "f");
        dto.setAllow_all_comment(u.isallowAllComment() ? "t" : "f");
        dto.setAllow_all_act_msg(u.isallowAllActMsg() ? "t" : "f");
        dto.setAvatar_large(u.getavatarLarge());
        dto.setOnline_status(u.getonlineStatus());
        dto.setRemark(u.getRemark());
        dto.setVerified_reason(u.getVerified_reason());
        dto.setWeihao(u.getWeihao());
        dto.setLang(u.getLang());
        dto.setVerifiedType(u.getverifiedType());
        return dto;
    }

}
