package com.oa.cis.service;

import com.alibaba.fastjson.JSONObject;
import com.oa.cis.vo.UserVo;

public interface UserService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    JSONObject selectUserameAndPassWord(String username, String password);

    /**
     * 用户注册
     *
     * @param userVo
     * @return
     */
    JSONObject insertUserInfo(UserVo userVo);

}
