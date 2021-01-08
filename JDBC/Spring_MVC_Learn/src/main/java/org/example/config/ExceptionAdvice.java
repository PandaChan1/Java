package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.APPexception;
import org.example.model.JSONResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
@Slf4j   //使用lombok的日志注解
public class ExceptionAdvice {

    @ExceptionHandler(APPexception.class)
    @ResponseBody
    public Object MyHandler(APPexception e) {
        JSONResponse jsonResponse = new JSONResponse();
        //自定义异常，保存错误码和错误消息
            jsonResponse.setMessage(e.getMessage());
            jsonResponse.setCode(e.getCode());
            log.debug(transform(e));
            return jsonResponse;

        //非自定义异常（英文错误信息，堆栈信息，不能给用户看）：
        // 指定一个错误码，错误消息（未知错误，请联系管理员）
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handler(Exception e) {
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setCode("error");
        jsonResponse.setMessage("未知错误");
        log.debug(transform(e));
        return jsonResponse;
    }


    public String transform(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw =  new PrintWriter(sw,true);
        e.printStackTrace(pw);   //打印异常堆栈信息到PrintWriter ，PrintWriter会传到StringWriter中去

        return sw.toString();
    }
}
