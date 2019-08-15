package com.likai.datebase.dao;

import com.likai.datebase.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    @Select("    select id, createBy, createById, createTime, deleteStatus, lastModifyBy, lastModifyById, \n" +
            "    lastModifyTime, version, accountBalance, address, areaId, cardNo, cityId, email, \n" +
            "    headPhotoPath, mobile, nickName, password, qq, seqNo, trueName, userName, userType, \n" +
            "    innerUser, expirDate, recommend, vipLevel, weixin, weixinCodePath, weixinLogoPath, \n" +
            "    birthday, sex, provinceId, yaoqingUserId, weixinOpenId, remark\n" +
            "    from yyg_user")
    List<User> selectAll_s();
}