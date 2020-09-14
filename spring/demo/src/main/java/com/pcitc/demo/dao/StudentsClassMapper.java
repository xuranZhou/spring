package com.pcitc.demo.dao;

import com.pcitc.demo.pojo.Students;
import com.pcitc.demo.pojo.StudentsClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentsClassMapper {

    StudentsClass getClassByStudentsClass(Long studentsClass);

    List<StudentsClass> getAllClass();

    void saveStudentClass(StudentsClass studentsClass);

    void updateStudentsClass(StudentsClass studentsClass);

    void deleteStudentsClassByClass(long studentsClass);

//    StudentsClass getStudentsClassById(Long studentsClass);
}
