package com.oa.cis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.oa.cis.mapper.UserMapper;
import com.oa.cis.service.UserService;
import com.oa.cis.util.EncryptionUtils;
import com.oa.cis.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service("userService")
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

    /**
     * 用户注册
     *
     * @param userVo
     * @return
     */
    @Override
    public JSONObject insertUserInfo(UserVo userVo) {
        Integer result = userMapper.insertUserInfo(userVo);
        JSONObject jsonObj = new JSONObject();
        if (result > 0) {
            jsonObj.put("code", "1");
            jsonObj.put("msg", "注册成功");
            return jsonObj;
        }
        jsonObj.put("code", "0");
        jsonObj.put("msg", "用户注册失败");
        return jsonObj;
    }

    /**
     * 修改密码
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Integer updatePasswordByUsername(String username, String password) {
        return userMapper.updatePasswordByUsername(username, password);
    }

    /**
     * 根据用户名查询密码
     *
     * @param username
     * @return
     */
    @Override
    public String selectPasswordByUsername(String username) {
        return userMapper.selectPasswordByUsername(username);
    }
}
