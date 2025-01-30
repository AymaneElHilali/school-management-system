package com.elhilali.sms.dataAcces.repo;

import com.elhilali.sms.dataAcces.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>,UserRepo {

}
