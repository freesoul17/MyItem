package com.jason.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public ResultMsg doException(Exception e){
        e.printStackTrace();
        return new ResultMsg("服务器故障，请联系管理员");
    }
}
