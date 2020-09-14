package com.itheima.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    @Test
    //测试spring产生jdbcTemplate对象
    public void test2() throws PropertyVetoException{
        ApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values (?,?)", "lucky", 1000);
        System.out.println(row);
    }

    @Test
    //测试JdbcTemplate开发步骤
    public void test1() throws PropertyVetoException {

        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //8.0.21版本的driver：com.mysql.cj.jdbc.Driver
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        //url：jdbc:mysql://localhost:3306/test?serverTimezone=CST&useSSL=false&useUnicode=true&characterEncoding=UTF-8
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=CST&useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("password");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象，知道数据库在哪儿
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        int row = jdbcTemplate.update("insert into account values (?,?)","timmy",50000);
        System.out.println(row);

    }
}
