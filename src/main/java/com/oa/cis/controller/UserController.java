package com.oa.cis.controller;

import com.alibaba.fastjson.JSONObject;
import com.oa.cis.constants.UserConstants;
import com.oa.cis.service.UserService;
import com.oa.cis.util.EncryptionUtils;
import com.oa.cis.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

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

    /**
     * 用户注册
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject regist(@RequestBody String params) {
        JSONObject jsonObj = (JSONObject) JSONObject.parse(params);

        UserVo userVo = new UserVo();
        userVo.setUsername(jsonObj.getString("username"));
        userVo.setPassword(jsonObj.getString("password"));
        userVo.setSex((jsonObj.getString("sex").toCharArray())[0]);
        userVo.setPhone(jsonObj.getString("phone"));
        userVo.setEmail(jsonObj.getString("email"));
        /* MD5+SHA-512 加密*/
        userVo.setPassword(EncryptionUtils.encryption(userVo.getPassword()));
        userVo.setRole(1);
        userVo.setCreateTime(new Date());
        userVo.setUpdateTime(new Date());
        JSONObject jsonObject = userService.insertUserInfo(userVo);
        return jsonObject;
    }

}
