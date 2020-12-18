package org.example.service;

import org.example.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginService {
    @Autowired
    private LoginDAO loginDAO;
}
