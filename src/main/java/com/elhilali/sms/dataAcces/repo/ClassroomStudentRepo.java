package com.elhilali.sms.dataAcces.repo;

import com.elhilali.sms.dataAcces.entity.ClassroomStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomStudentRepo extends JpaRepository<ClassroomStudent,Long> {

}
