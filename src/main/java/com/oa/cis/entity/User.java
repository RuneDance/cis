package com.oa.cis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    //用户表id
    private Integer id;

    //用户名
    private String username;

    //用户密码，密码：MD5+SHA-512 加密
    private String password;

    //用户性别
    private char sex;

    //用户手机号
    private String phone;

    //用户邮箱
    private String email;

    //用户角色：0-管理员,1-普通用户,2-访客
    private Integer role;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;


}