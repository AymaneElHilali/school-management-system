package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.repo.AdminRepo;
import com.elhilali.sms.dataAcces.repo.DirectorRepo;
import com.elhilali.sms.dataAcces.repo.StudentRepo;
import com.elhilali.sms.dataAcces.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final StudentRepo studentRepo;


    private final TeacherRepo teacherRepo;


    private final AdminRepo adminRepo;


    private final DirectorRepo directorRepo;

    @Autowired
    public UserService(StudentRepo studentRepo, TeacherRepo teacherRepo, AdminRepo adminRepo, DirectorRepo directorRepo) {
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
        this.adminRepo = adminRepo;
        this.directorRepo = directorRepo;
    }

    public boolean emailAlreadyUsed(String email){
        if (studentRepo.existsByEmail(email) || teacherRepo.existsByEmail(email) || adminRepo.existsByEmail(email) || directorRepo.existsByEmail(email) ){
            return true;
        }
        return false;
    }

}
