package com.itheima.demo;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.soap.SOAPBinding;

public class UserController {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.save();
       ApplicationContext app =new ClassPathXmlApplicationContext("applicationContext.xml");
       UserService userService = (UserService) app.getBean("userService");
       userService.save();
//        UserService userService = new UserServiceImpl();
//        userService.save();

    }
}
