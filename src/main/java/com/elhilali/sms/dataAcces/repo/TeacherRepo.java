package com.elhilali.sms.dataAcces.repo;

import com.elhilali.sms.dataAcces.entity.Student;
import com.elhilali.sms.dataAcces.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long>,UserRepo {

}
