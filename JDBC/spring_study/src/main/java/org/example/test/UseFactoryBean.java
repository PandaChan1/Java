package org.example.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UseFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        Person p = new Person();
        p.setName("老王");
        p.setAge(52);
        return p;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
