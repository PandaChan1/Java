package org.example.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 执行完Controller的请求映射方法,如果有响应体内容，可以在写入http协议响应体之前重写
     * @param body  请求映射方法返回值
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof JSONResponse) {
            return body;
        }

        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setSuccess(true);
        jsonResponse.setData(body);

        if (body instanceof  String) {
            try {
                return objectMapper.writeValueAsString(jsonResponse);
            } catch (JsonProcessingException e) {
               throw new RuntimeException("json序列化出错:"+ jsonResponse);
            }
        }
        return jsonResponse;
    }
}
