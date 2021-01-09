package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
}
