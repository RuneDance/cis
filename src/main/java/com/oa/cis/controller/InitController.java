package com.oa.cis.controller;

import com.oa.cis.constants.UserConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RestController
public class InitController {
    /**
     * 默认首页
     *
     * @param session
     * @return
     */
    @RequestMapping("/")
    public ModelAndView init(HttpSession session) {
        if (session.getAttribute(UserConstants.SESSION_USERNAME) != null) {
            return new ModelAndView("/index");
        }
        return new ModelAndView("/login");
    }

    /**
     * 首页
     *
     * @param session
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpSession session) {
        if (session.getAttribute(UserConstants.SESSION_USERNAME) != null) {
            return new ModelAndView("/index");
        }
        return new ModelAndView("/login");
    }

    /**
     * errors
     *
     * @return
     */
    @RequestMapping("/errors")
    public ModelAndView errors() {
        return new ModelAndView("/errors");
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("/regist")
    public ModelAndView regist() {
        return new ModelAndView("/regist");
    }

    /**
     * home 页面
     *
     * @return
     */
    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("/home");
    }

    /**
     * 表单应用
     *
     * @return
     */
    @RequestMapping("/formApply")
    public ModelAndView formApply() {
        return new ModelAndView("/formApply");
    }

    /**
     * 表单信息详情
     *
     * @return
     */
    @RequestMapping("/formInfoDetail")
    public ModelAndView formInfoDetail(HttpSession session) {
        if (session.getAttribute(UserConstants.SESSION_USERNAME) != null) {
            if (session.getAttribute(UserConstants.SESSION_USERNAME).toString().equals("admin")) {
                return new ModelAndView("/formInfoDetail");
            }
            return new ModelAndView("/index");
        }
        return new ModelAndView("/login");

    }

    /**
     * 审核管理
     *
     * @return
     */
    @RequestMapping("/examineManage")
    public ModelAndView examineManage() {
        return new ModelAndView("/examineManage");
    }


    @RequestMapping("/demo")
    public ModelAndView demo() {
        return new ModelAndView("/demo");
    }
}
