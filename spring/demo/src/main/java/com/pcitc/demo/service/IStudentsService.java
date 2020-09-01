package com.pcitc.demo.service;

import com.pcitc.demo.pojo.Students;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface IStudentsService {
    List<Students> getAllStudents();

    void saveStudent(Students students);

    void updateStudents(Students students);

    void deleteStudentsById(long studentsId);
}
