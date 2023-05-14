package com.example.learn.annotation.impl;

import com.example.learn.annotation.IUser;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

@Service(value = "IUserServiceImpl")
public class IUserServiceImpl implements IUser {
    private final String name = "UserServiceImpl";

    @Override
    public String get() {
        return name;
    }
}
