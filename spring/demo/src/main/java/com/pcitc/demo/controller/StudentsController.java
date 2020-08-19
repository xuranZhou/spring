package com.pcitc.demo.controller;

import com.pcitc.demo.pojo.Students;
import com.pcitc.demo.service.IStudentsService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userController")
public class StudentsController {
   @Autowired
    private IStudentsService studentsService;

   @GetMapping("/getAllStudents")
   public Object getAllStudents(){
       List<Students> allStudents = studentsService.getAllStudents();
       return allStudents;
   }
}
