package org.example.test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class usePerson {



    @Bean
    public Person person1(){
        Person person = new Person();
        person.setAge(23);
        person.setName("张三");
        return person;
    }

    @Bean
    public Person person2() {
        Person person = new Person();
        person.setName("李四");
        person.setAge(15);
        return person;
    }

}
