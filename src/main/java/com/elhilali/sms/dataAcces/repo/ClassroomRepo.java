package com.elhilali.sms.dataAcces.repo;

import com.elhilali.sms.dataAcces.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom,Long> {

}
