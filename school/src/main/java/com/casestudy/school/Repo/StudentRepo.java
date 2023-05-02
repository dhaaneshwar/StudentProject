package com.casestudy.school.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.school.Model.Student;
import com.google.common.base.Optional;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

  Optional<Student> findByStudentName(String studentName);
  
}
