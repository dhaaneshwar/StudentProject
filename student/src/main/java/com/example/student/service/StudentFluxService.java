package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentFluxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class StudentFluxService {

    @Autowired
    private StudentFluxRepository repository;

    public Mono<Student> addStudent(Student student) {
        return this.repository.save(student);
    }

    public Flux<Student> getAllStudent() {
        return this.repository.findAll();
    }

    public Mono<Student> updateStudent(Long id, Mono<Student> student) {

        return this.repository.findById(id)
                .flatMap(s->student.map(t->{
                    s.setStudentName(t.getStudentName());
                    s.setBranch(t.getBranch());
                    return t;
                }))
                .flatMap(s->this.repository.save(s));

    }

    public Flux<Student> getStudentByBranch(String reqBranch) {

        Flux<Student> students = repository.findByBranch(reqBranch);
        return students;

    }
}
