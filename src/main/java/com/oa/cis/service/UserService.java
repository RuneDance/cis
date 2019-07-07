package com.oa.cis.service;

import com.alibaba.fastjson.JSONObject;
import com.oa.cis.vo.UserVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 修改密码
     *
     * @param username
     * @return
     */
    Integer updatePasswordByUsername(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password);

    /**
     * 根据用户名查询密码
     *
     * @param username
     * @return
     */
    String selectPasswordByUsername(@RequestParam(value = "username") String username);

}
