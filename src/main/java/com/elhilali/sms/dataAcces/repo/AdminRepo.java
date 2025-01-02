package com.elhilali.sms.dataAcces.repo;

import com.elhilali.sms.dataAcces.entity.Admin;
import com.elhilali.sms.dataAcces.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long>,UserRepo {

}
