package com.pcitc.demo.service;

import com.pcitc.demo.pojo.StudentsClass;

import java.util.List;

public interface IClassService {

    StudentsClass getClassByStudentsClass(Long studentsClass);

    List<StudentsClass> getAllClass();

    String saveStudentClass(StudentsClass studentsClass);

    String updateStudentsClass(StudentsClass studentsClass);

    String deleteStudentsClassByClass(long studentsClass);
}
