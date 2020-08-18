package com.pcitc.demo.dao;

import com.pcitc.demo.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentsMapper {
    List<Students> getAllStudents();
}
