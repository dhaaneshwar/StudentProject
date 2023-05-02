package com.casestudy.school.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.casestudy.school.Model.Student;
import com.casestudy.school.Repo.StudentRepo;

@Service
public class StudentService {
  
  @Autowired
  private StudentRepo studentRepo;

  public Student addStudent(Student student){
    studentRepo.save(student);
    return student;
  }

  public String updateStudent(Student student, String studentId){
    Optional<Student> optionalStudent = studentRepo.findById(studentId);
    if(optionalStudent.isPresent()){
      Student savStudent = optionalStudent.get();
      savStudent.setStudentName(student.getStudentName());
      savStudent.setStudentBranch(student.getStudentBranch());
      studentRepo.save(savStudent);
      return "Student details updated : " + savStudent;
    }
    else{
      return "No student with details " + student + " was found!";
    }
  }

  public List<Student> allStudents(){
    List<Student> allStudents = studentRepo.findAll();
    return allStudents;
  }

  public List<Student> studentsByBranch(String studentBranch){
    List<Student> students = studentRepo.findAll();
    return students.stream().filter((student)-> student.getStudentBranch().equals(studentBranch)).collect(Collectors.toList());
  }
}
