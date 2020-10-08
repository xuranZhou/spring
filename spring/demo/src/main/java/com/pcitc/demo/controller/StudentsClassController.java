package com.pcitc.demo.controller;

import com.pcitc.demo.pojo.StudentsClass;
import com.pcitc.demo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/StudentsClass")
public class StudentsClassController {

    @Autowired
    private IClassService iClassService;

    @GetMapping("/StudentsClass/{studentsClass}")
    public Object getClassByStudentsClass(@PathVariable("studentsClass") Long studentsClass){

        StudentsClass allStudentsClass = iClassService.getClassByStudentsClass(studentsClass);
        return allStudentsClass;

    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/StudentsClass")
    public Object getAllClass(){

        List<StudentsClass> allStudentsClass = iClassService.getAllClass();
        return allStudentsClass;

    }

    /**
     * 添加班级信息
     * @param studentsClass
     * @return
     */
    @PostMapping("/StudentsClass")
    public String saveStudentClass(@RequestBody StudentsClass studentsClass){
        String s = iClassService.saveStudentClass(studentsClass);
        return s;
    }

    /**
     * 修改班级信息
     * @param studentsClass
     * @return
     */
    @PutMapping("/StudentsClass")
    public String updateStudents(@RequestBody StudentsClass studentsClass){
        String s = iClassService.updateStudentsClass(studentsClass);
        return s;
    }

    @DeleteMapping("/StudentsClass/{studentsClass}")
    public String deleteStudentsClassByClass(@PathVariable("studentsClass") long studentsClass) {
        String s = iClassService.deleteStudentsClassByClass(studentsClass);
        return s;
    }

}
