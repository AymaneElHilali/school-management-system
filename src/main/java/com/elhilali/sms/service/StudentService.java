package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.LoginRequestDTO;
import com.elhilali.sms.dataAcces.dto.LoginResponseDTO;
import com.elhilali.sms.dataAcces.dto.SignupRequestDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import com.elhilali.sms.dataAcces.entity.Student;
import com.elhilali.sms.dataAcces.repo.StudentRepo;
import com.elhilali.sms.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    JwtService jwtService;


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

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){

        // get the Student by the email
        Student student = studentRepo.findByEmail(loginRequestDTO.getEmail());

        // check the student is not null , and if they have the sam password
        if (student!=null && loginRequestDTO.getPassword().equals(student.getPassword())){

            LoginResponseDTO loginResponseDTO = student.ToLoginResponseDTO();
            String token = jwtService.generateToken(student.getEmail());
            loginResponseDTO.setJwt(token);
            return loginResponseDTO;

        }
        else {
            throw new ConflictException("wrong email or password");
        }


    }
}
