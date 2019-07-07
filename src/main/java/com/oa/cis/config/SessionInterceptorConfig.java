package com.oa.cis.config;

import com.oa.cis.constants.UserConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yyt on 2018/7/24.
 */
@Component
public class SessionInterceptorConfig implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(SessionInterceptorConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (request.getSession().getAttribute(UserConstants.SESSION_USERNAME) != null) {
            return true;
        } else {
            if (requestURI.equals("/login")) {
                return true;
            }
            response.sendRedirect("/login.html");
            //request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
        System.out.println("afterCompletion");
    }
}
