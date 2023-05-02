package com.casestudy.school.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
  @Id
  private String studentId;
  private String studentName;
  private String studentBranch;
  public String getStudentId() {
    return studentId;
  }
  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }
  public String getStudentName() {
    return studentName;
  }
  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }
  public String getStudentBranch() {
    return studentBranch;
  }
  public void setStudentBranch(String studentBranch) {
    this.studentBranch = studentBranch;
  }


}
