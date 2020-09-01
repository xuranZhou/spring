package com.pcitc.demo.dao;

import com.pcitc.demo.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

//@Mapper
@Component
public interface StudentsMapper {
    List<Students> getAllStudents();

    void saveStudent(Students students);

    void updateStudents(Students students);

    Students getStudentsById(Long studentsId);

    List<Students> getStudentsByClass(Long studentsClass);

    void deleteStudentsById(long studentsId);

}
