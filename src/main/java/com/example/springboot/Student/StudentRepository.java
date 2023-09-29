package com.example.springboot.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student,Long> {

    //jpql
   @Query("SELECT s from Student s where  s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
