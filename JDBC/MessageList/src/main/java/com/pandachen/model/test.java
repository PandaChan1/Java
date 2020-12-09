package com.pandachen.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandachen.model.Beans.Message;

import java.util.List;

public class test {
    public static void main(String[] args) throws JsonProcessingException {
        String str = "[\n" +
                "    {\n" +
                "        \"id\":1,\n" +
                "        \"who\":\"panda\",\n" +
                "        \"when\":\"2020\",\n" +
                "        \"what\":\"hello\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":2,\n" +
                "        \"who\":\"panda2\",\n" +
                "        \"when\":\"2020-12\",\n" +
                "        \"what\":\"hello2\"\n" +
                "    }\n" +
                "]";
        ObjectMapper mapper = new ObjectMapper();

        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, Message.class);

        List<Message> ans = mapper.readValue(str, type);
        System.out.println(ans);

        String str2 = "  {\n" +
                "        \"id\":1,\n" +
                "        \"who\":\"panda\",\n" +
                "        \"when\":\"2020\",\n" +
                "        \"what\":\"hello\"\n" +
                "    }";
        Message message = mapper.readValue(str2,Message.class);
        System.out.println(message);
    }


}
