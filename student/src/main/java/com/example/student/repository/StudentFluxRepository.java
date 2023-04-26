package com.example.student.repository;

import com.example.student.entity.Student;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentFluxRepository extends R2dbcRepository<Student,Long> {
    Flux<Student> findByBranch(String reqBranch);
}
