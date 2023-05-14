package com.example.learn.service;

import com.example.learn.annotation.IUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplWithParam implements IUser {
    private String name = "UserServiceImplWithParam";
    @Override
    public String get() {
        return this.name;
    }
}
