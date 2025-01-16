package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.entity.Role;
import com.elhilali.sms.dataAcces.repo.AdminRepo;
import com.elhilali.sms.dataAcces.repo.DirectorRepo;
import com.elhilali.sms.dataAcces.repo.StudentRepo;
import com.elhilali.sms.dataAcces.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private final StudentRepo studentRepo;


    private final TeacherRepo teacherRepo;


    private final AdminRepo adminRepo;


    private final DirectorRepo directorRepo;

    @Autowired
    public MyUserDetailsService(StudentRepo studentRepo, TeacherRepo teacherRepo, AdminRepo adminRepo, DirectorRepo directorRepo) {
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
        this.adminRepo = adminRepo;
        this.directorRepo = directorRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return studentRepo.findByEmail(email);
    }
    public UserDetails loadUserByEmail(String email,Role role) throws UsernameNotFoundException {
        if (role == Role.student) {
            return studentRepo.findByEmail(email);
        } else if (role == Role.teacher) {
            return teacherRepo.findByEmail(email);
        } else if (role == Role.admin) {
            return adminRepo.findByEmail(email);
        }
        else if (role == Role.director) {
            return directorRepo.findByEmail(email);
        }
        return null;
    }

}
