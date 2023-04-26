package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentFluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class StudentFluxController {

    @Autowired
    private StudentFluxService service;

    @PostMapping("/add")
    public Mono<Student> addStudent(@RequestBody Mono<Student> student) {
        return student.flatMap(this.service::addStudent);
    }

    @GetMapping("/getAll")
    public Flux<Student> getAllStudent(){
        return this.service.getAllStudent();
    }

    @PutMapping("/update/{id}")
    public Mono<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Mono<Student> student){
        return this.service.updateStudent(id,student);
    }

    @GetMapping("/getByBranch/{branch}")
    public Flux<Student> getStudentByBranch(@PathVariable("branch") String branch) {
        return this.service.getStudentByBranch(branch);
    }
}
