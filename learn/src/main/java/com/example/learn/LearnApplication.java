package com.example.learn;

import com.example.learn.annotation.impl.IUserServiceImpl;
import com.example.learn.annotation.impl.UserRepositoryImpl;
import com.example.learn.service.UserServiceImplWithParam;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(LearnApplication.class, args);
//        UserServiceImplWithParam userServiceImplWithParam =context.getBean(UserServiceImplWithParam.class);
//        System.out.println(userServiceImplWithParam.get());
//        IUserServiceImpl iUserServiceImpl=(IUserServiceImpl)context.getBean("IUserServiceImpl");
//        System.out.println(iUserServiceImpl.get());
        UserRepositoryImpl userRepositoryImpl1 = (UserRepositoryImpl) context.getBean("userRepositoryImpl");
//        System.out.println(userRepositoryImpl1);


    }

}
