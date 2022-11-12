package com.jason.config.interceptors;

import com.alibaba.fastjson.JSON;
import com.jason.common.BaseContext;
import com.jason.common.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      if(  request.getSession().getAttribute("employee")!=null){
          //根据session来获取之前我们存的id值
          Long empId = (Long) request.getSession().getAttribute("employee");
          //使用BaseContext封装id
          BaseContext.setCurrentId(empId);
          return true;
      }else{
          response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));
          return false;
      }
    }
}
