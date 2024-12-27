package com.elhilali.authentification.dataAcces.repo;

import com.elhilali.authentification.dataAcces.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    Student findByEmail(String email);

}
