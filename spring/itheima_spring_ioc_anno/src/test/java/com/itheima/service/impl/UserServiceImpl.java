package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// <bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
@Scope("prototype")
public class UserServiceImpl  implements UserService {
    @Value("${jdbc.driver}")//从spring容器中为dirver找到并赋值属于其的key
    private String driver;
   //<property name="userDao" ref="userDao"></property>
//    @Autowired
//    @Qualifier("userDao")
    @Resource(name = "userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("Service对象的初始化方法");
    }
    @PostConstruct
    public void destory(){
        System.out.println("Service对象的销毁方法");
    }
}
