package com.pcitc.demo.pojo;


import java.util.List;

public class StudentsClass {

  private long studentsClass;
  private String className;
  private List<Students> studentsList;

  public List<Students> getStudentsList() {
    return studentsList;
  }

  public void setStudentsList(List<Students> studentsList) {
    this.studentsList = studentsList;
  }

  public long getStudentsClass() {
    return studentsClass;
  }

  public void setStudentsClass(long studentsClass) {
    this.studentsClass = studentsClass;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


}
