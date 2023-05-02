package com.casestudy.school.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.casestudy.school.Model.Student;
import com.casestudy.school.Services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
  
  @Autowired
  private StudentService studentService;

  @PostMapping("/addStudent")
  public String addStudent(@RequestBody Student student){
    studentService.addStudent(student);
    return "Student has been added successfully!";
  }

  @GetMapping("/all")
  public List<Student> getAllStudents(){
    return studentService.allStudents();
  }

  @PutMapping("/update/{studentId}")
  public String updateStudent(@RequestBody Student student, @PathVariable("studentId")String studentId){
    return studentService.updateStudent(student, studentId);
  }

  @GetMapping("/byStudentBranch/{branchName}")
  public List<Student> getStudentByBranch(@PathVariable("branchName")String branchName){
    return studentService.studentsByBranch(branchName);
  }
}
