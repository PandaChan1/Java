package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class setlearn {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }

    }
    static List<Message> process(List < Message > received){
        // TODO: 按sequence去除重复消息
        List<Message> newreceived =new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for (var i:received){
            if (set.add(i.sequence)){
                newreceived.add(i);
            };
        }

        return newreceived;
    }
}
    class Message {
        public final int sequence;
        public final String text;
        public Message(int sequence, String text) {
            this.sequence = sequence;
            this.text = text;
        }
    }
