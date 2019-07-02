package com.oa.cis.controller;

import com.alibaba.fastjson.JSONObject;
import com.oa.cis.constants.UserConstants;
import com.oa.cis.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户Controller
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        JSONObject jsonObject = userService.selectUserameAndPassWord(username, password);
        if (jsonObject.getString("code").equals("1")) {
            //将用户名保存在session中
            session.setAttribute(UserConstants.SESSION_USERNAME, username);
            return jsonObject;
        }
        return jsonObject;
    }


}
