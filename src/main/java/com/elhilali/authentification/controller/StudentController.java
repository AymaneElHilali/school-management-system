package com.elhilali.authentification.controller;


import com.elhilali.authentification.dataAcces.dto.LoginRequestDTO;
import com.elhilali.authentification.dataAcces.dto.LoginResponseDTO;
import com.elhilali.authentification.dataAcces.dto.SignupRequestDTO;
import com.elhilali.authentification.dataAcces.dto.SignupResponseDTO;
import com.elhilali.authentification.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student/signup")
    public SignupResponseDTO signup(@Valid @RequestBody SignupRequestDTO signupRequestDTO){

        return studentService.signup(signupRequestDTO) ;

    }
//    @PostMapping("/lgoin")
//    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){
//
//        return ;
//
//    }



}
