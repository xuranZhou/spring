package com.pcitc.demo.controller;

import com.pcitc.demo.pojo.Students;
import com.pcitc.demo.service.IStudentsService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class StudentsController {

   @Autowired
   private IStudentsService studentsService;

    /**
     * 查询所有学生信息
     * @return
     */
   @GetMapping("/Students")
   public Object getAllStudents(){
       List<Students> allStudents = studentsService.getAllStudents();
       return allStudents;
   }

    /**
     * 添加学生
     * @param students
     * @return
     */
   @PostMapping("/Student")
   public String saveStudent(@RequestBody Students students){
        studentsService.saveStudent(students);
        return "success";
   }

    /**
     * 修改学生信息
     * @param students
     * @return
     */
   @PutMapping("/Students")
    public String updateStudents(@RequestBody Students students){
        studentsService.updateStudents(students);
        return "success";
   }

    @DeleteMapping("/Students")
    public String deleteStudentsById(@PathVariable long studentsId) {
       studentsService.deleteStudentsById(studentsId);
       return null;
    }


}
