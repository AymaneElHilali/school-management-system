package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.entity.User;
import com.elhilali.sms.dataAcces.repo.StudentRepo;
import com.elhilali.sms.dataAcces.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TeacherRepo teacherRepo;

    public boolean emailAlreadyUsed(String email){
        if (studentRepo.existsByEmail(email) || teacherRepo.existsByEmail(email)){
            return true;
        }
        return false;
    }

}
