package org.example.exampleTest;

import org.example.model.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FactoryBeanTest implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setUsername("翩翩");
        user.setPassword(123);
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
