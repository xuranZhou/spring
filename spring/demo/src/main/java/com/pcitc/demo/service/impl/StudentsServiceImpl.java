package com.pcitc.demo.service.impl;

import com.pcitc.demo.dao.StudentsMapper;
import com.pcitc.demo.pojo.Students;
import com.pcitc.demo.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements IStudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public List<Students> getAllStudents() {
        List<Students> students = studentsMapper.getAllStudents();
        return students;
    }
}
