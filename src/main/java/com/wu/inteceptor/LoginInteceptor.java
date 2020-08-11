package com.wu.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        Cookie[]  cookies = request.getCookies();
        HttpSession session =  request.getSession();
       /* for (int i = 0; i < cookies.length; i++) {
            Cookie cookie =  cookies[i];
            String name = cookie.getName();
           *//* if(name.equalsIgnoreCase("token") && cookie.getValue().equalsIgnoreCase(session.getId())){
                //前端记录已经登录成功过
                return true;
            }*//*
            if(name.equalsIgnoreCase("token")){
                //前端记录已经登录成功过
                return true;
            }
        }*/
        boolean isCookie = false;
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie =  cookies[i];
            String name = cookie.getName();
            if(name.equalsIgnoreCase("token")){
                //前端记录已经登录成功过
                cookie.setMaxAge(60*1000*60);
                cookie.setDomain(request.getServerName());
                cookie.setPath("/");
                response.addCookie(cookie);
                isCookie =  true;
                break;
            }
        }
        if(!isCookie){
            System.out.println("cookie的token已经过期了");
        }
        Object userId = session.getAttribute("token");
        String token = null;
        if(userId!=null){
            token = (String) userId;
            if(token.equalsIgnoreCase(session.getId())){
                //说明已经登录过了；
                return true;
            }
        }
        //未登录的则重定向到login页面
        response.sendRedirect("/login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
