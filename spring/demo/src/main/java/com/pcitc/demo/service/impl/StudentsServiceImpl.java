package com.pcitc.demo.service.impl;

import com.pcitc.demo.dao.StudentsClassMapper;
import com.pcitc.demo.dao.StudentsMapper;
import com.pcitc.demo.pojo.Students;
import com.pcitc.demo.pojo.StudentsClass;
import com.pcitc.demo.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements IStudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private StudentsClassMapper studentsClassMapper;

    @Override
    public List<Students> getAllStudents() {
        List<Students> students = studentsMapper.getAllStudents();
        return students;
    }

    @Override
    public void saveStudent(Students students) {
        StudentsClass classByStudentsClass = studentsClassMapper.getClassByStudentsClass(students.getStudentsClass());
        if(classByStudentsClass != null) {
            studentsMapper.saveStudent(students);
        }
    }

    @Override
    public void updateStudents(Students students) {
        //再修改数据之前先查询是否有这条数据
        Students students1 = studentsMapper.getStudentsById(students.getStudentsId());
        if (students != null){
            studentsMapper.updateStudents(students);
        }
    }
    @Override
    public void deleteStudentsById(long studentsId){
        //删除前先查找是否有此数据
        Students students = studentsMapper.getStudentsById(studentsId);
        if(studentsId != 0){
            studentsMapper.deleteStudentsById(studentsId);
        }
    }
}
