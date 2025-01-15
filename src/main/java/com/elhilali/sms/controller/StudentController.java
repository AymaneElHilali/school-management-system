package com.elhilali.sms.controller;


import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student/signup")
    public SignupResponseDTO signup(@Valid @RequestBody SignupRequestDTO signupRequestDTO){

        return studentService.signup(signupRequestDTO) ;

    }
    @PostMapping("/student/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        return studentService.login(loginRequestDTO);

    }

    @PutMapping("/student/update")
    public UpdateBySelfDto updateBySelf(@Valid @RequestBody UpdateBySelfDto updateBySelfDto){

        return studentService.updateBySelf(updateBySelfDto);

    }

    @GetMapping("/test")
    public String test(){
        return "pass";
    }



}
