package com.itheima.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.activation.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    //测试Spring容器产生数据对象
    public void test2() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);
        Class<? extends DataSource> connection = dataSource.getClass();
    }
    @Test
    //手动创建c3p0数据源(加载properties配置文件)
    public void test3() throws Exception {
        //读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String dirver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        //创建数据对象，设置连接参数
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(dirver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

//    @Test
    //手动创建c3p0数据源
  public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("password");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
}
