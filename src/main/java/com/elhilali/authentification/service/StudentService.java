package com.elhilali.authentification.service;

import com.elhilali.authentification.dataAcces.dto.SignupRequestDTO;
import com.elhilali.authentification.dataAcces.dto.SignupResponseDTO;
import com.elhilali.authentification.dataAcces.entity.Student;
import com.elhilali.authentification.dataAcces.repo.StudentRepo;
import com.elhilali.authentification.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;


    public SignupResponseDTO signup(SignupRequestDTO signupRequestDTO){

        //check if the email already used
        if (studentRepo.findByEmail(signupRequestDTO.getEmail())!=null){
            throw new ConflictException("Email already Used!");
        }

        // map from Dto to Student
        Student mapedStudent = signupRequestDTO.toEntity();
        // Save the Student
        Student savedStudent = studentRepo.save(mapedStudent);

        if (savedStudent.getEmail()==null){
            throw new ConflictException("signup failed");
        }

        // map from student to the DTO that we will return
        return savedStudent.ToSignupResponseDTO();


    }
}
