package com.oa.cis.controller;

import com.oa.cis.constants.UserConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RestController
public class InitController {
    @RequestMapping("/")
    public ModelAndView init(HttpSession session) {
        if (session.getAttribute(UserConstants.SESSION_USERNAME) != null) {
            return new ModelAndView("/index");
        }
        return new ModelAndView("/login");
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @RequestMapping("/regist")
    public ModelAndView regist() {
        return new ModelAndView("/regist");
    }

    @RequestMapping("/demo")
    public ModelAndView demo() {
        return new ModelAndView("/demo");
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("/home");
    }

    @RequestMapping("/formApply")
    public ModelAndView formApply() {
        return new ModelAndView("/formApply");
    }

    @RequestMapping("/formInfoDetail")
    public ModelAndView formInfoDetail() {
        return new ModelAndView("/formInfoDetail");
    }
}
