package com.pcitc.demo;

import com.pcitc.demo.dao.StudentsMapper;
import com.pcitc.demo.pojo.Students;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.pcitc.demo.dao")
class DemoApplicationTests {

    @Autowired
    private StudentsMapper studentsMapper;

    @Test
    void contextLoads() {
        List<Students> allStudents = studentsMapper.getAllStudents();
        System.out.println(allStudents);
    }

}
