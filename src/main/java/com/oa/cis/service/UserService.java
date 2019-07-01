package com.oa.cis.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    JSONObject selectUserameAndPassWord(String username, String password);
}
