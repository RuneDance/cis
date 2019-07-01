package com.oa.cis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.oa.cis.dao.UserMapper;
import com.oa.cis.service.UserService;
import com.oa.cis.util.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject selectUserameAndPassWord(@RequestParam("username") String username, @RequestParam("password") String password) {
        Integer result = userMapper.selectUserameAndPassWord(username, EncryptionUtils.encryption(password));
        JSONObject jsonObj = new JSONObject();
        if (result > 0) {
            jsonObj.put("code", "1");
            jsonObj.put("msg", "登陆成功");
            jsonObj.put("username", username);
            return jsonObj;
        }
        jsonObj.put("code", "0");
        jsonObj.put("msg", "用户名或密码不正确");
        return jsonObj;
    }
}
