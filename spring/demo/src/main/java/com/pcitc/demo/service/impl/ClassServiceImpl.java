package com.pcitc.demo.service.impl;

import com.pcitc.demo.dao.StudentsClassMapper;
import com.pcitc.demo.pojo.StudentsClass;
import com.pcitc.demo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    private StudentsClassMapper studentsClassMapper;
    private Object StudentsClass;

    @Override
    public StudentsClass getClassByStudentsClass(Long studentsClass) {
        StudentsClass studentsClasses = studentsClassMapper.getClassByStudentsClass(studentsClass);
        return studentsClasses;
    }

    @Override
    public List<StudentsClass> getAllClass() {
        List<StudentsClass> allClass = studentsClassMapper.getAllClass();
        return allClass;
    }
    @Override
    public String saveStudentClass(StudentsClass studentsClass) {
        StudentsClass classByStudentsClass = studentsClassMapper.getClassByStudentsClass(studentsClass.getStudentsClass());
        if(classByStudentsClass == null) {
            studentsClassMapper.saveStudentClass(studentsClass);
            return "success";
        }else {
            return "failed";
        }
    }

    @Override
    public String updateStudentsClass(StudentsClass studentsClass) {
        //再修改数据之前先查询是否有这条数据
        StudentsClass classByStudentsClass = studentsClassMapper.getClassByStudentsClass(studentsClass.getStudentsClass());
        if (classByStudentsClass != null){
            studentsClassMapper.updateStudentsClass(studentsClass);
            return "success";
        }
        return "failed";
    }

    @Override
    public String deleteStudentsClassByClass(long studentsClass){
        //删除前先查找是否有此数据
        StudentsClass studentsClass1 = studentsClassMapper.getClassByStudentsClass(studentsClass);
        if(studentsClass1 != null){
            studentsClassMapper.deleteStudentsClassByClass(studentsClass);
            return "success";
        }
        return "failed";
    }


}
