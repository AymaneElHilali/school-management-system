package com.elhilali.sms.dataAcces.repo;

import com.elhilali.sms.dataAcces.entity.ClassroomStudent;
import com.elhilali.sms.dataAcces.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomStudentRepo extends JpaRepository<ClassroomStudent,Long> {

    @Query("SELECT s FROM Student s JOIN s.classroomStudents cs WHERE cs.classroom.id = :classroomId")
    List<Student> findStudentsByClassroomId(Long classroomId);

}
