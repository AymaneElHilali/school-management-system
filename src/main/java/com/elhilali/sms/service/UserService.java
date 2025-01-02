package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.repo.AdminRepo;
import com.elhilali.sms.dataAcces.repo.DirectorRepo;
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

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    DirectorRepo directorRepo;

    public boolean emailAlreadyUsed(String email){
        if (studentRepo.existsByEmail(email) || teacherRepo.existsByEmail(email) || adminRepo.existsByEmail(email) || directorRepo.existsByEmail(email) ){
            return true;
        }
        return false;
    }

}
