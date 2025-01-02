package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.entity.Role;
import com.elhilali.sms.dataAcces.repo.AdminRepo;
import com.elhilali.sms.dataAcces.repo.StudentRepo;
import com.elhilali.sms.dataAcces.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    AdminRepo adminRepo;

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
        return null;
    }

}
