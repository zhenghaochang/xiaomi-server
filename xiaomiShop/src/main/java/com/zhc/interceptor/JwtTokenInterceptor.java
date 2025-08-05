package com.zhc.interceptor;

import com.zhc.common.context.BaseContext;
import com.zhc.common.properties.JwtProperties;
import com.zhc.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getMethod());
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        if(!(handler instanceof HandlerMethod)){
            //判断拦截到的是controller方法还是其他资源
            return true;//不是动态方法直接放行
        }

        try{
            /*String token = request.getHeader(jwtProperties.getTokenName()).substring(7);*/
            String token = request.getHeader(jwtProperties.getTokenName());
            Claims claims = JwtUtil.parseJwt(jwtProperties.getSecretKey(), token);
            String userId = claims.get("userId").toString();
            Integer i = Integer.valueOf(userId);
            BaseContext.setCurrentId(i);
            return true;
        }catch (Exception e){
            //token出了问题，返回状态码401
            response.setStatus(401);
            return false;//不放行
        }

    }
}
