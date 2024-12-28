package com.elhilali.sms.controller;


import com.elhilali.sms.dataAcces.dto.LoginRequestDTO;
import com.elhilali.sms.dataAcces.dto.LoginResponseDTO;
import com.elhilali.sms.dataAcces.dto.SignupRequestDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import com.elhilali.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        return studentService.login(loginRequestDTO);

    }
    @GetMapping("/test")
    public String test(){
        return "pass";
    }



}
