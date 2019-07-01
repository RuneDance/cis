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
}
