package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
    //jackson 框架中，对json字符串和java对象之间相互转换的类
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     *
     */
    public static String serialze(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("java对象序列化为json字符串出错");
        }
    }

}
