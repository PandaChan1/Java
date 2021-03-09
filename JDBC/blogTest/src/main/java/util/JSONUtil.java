package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {
    //jackson 框架中，对json字符串和java对象之间相互转换的类
    private static final ObjectMapper MAPPER = new ObjectMapper();



    //序列化
    public static String serialize(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("java对象序列化为json字符串出错");
        }
    }

    //反序列化

    /**
     *
     * @param is 输入流
     * @param clazz  指定要反序列化的java类型
     * @param <T>
     * @return  反序列后的java对象
     */
    public static<T> T Deserilize(InputStream is, Class<T> clazz)  {
        try {
            return MAPPER.readValue(is,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("反序列化失败");
        }
    }

}
