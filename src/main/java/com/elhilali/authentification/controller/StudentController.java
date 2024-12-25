package com.elhilali.authentification.controller;


import com.elhilali.authentification.dataAcces.dto.LoginRequestDTO;
import com.elhilali.authentification.dataAcces.dto.LoginResponseDTO;
import com.elhilali.authentification.dataAcces.dto.SignupRequestDTO;
import com.elhilali.authentification.dataAcces.dto.SignupResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @PostMapping("/lgoin")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        return "";

    }
    @PostMapping("/student/signup")
    public SignupResponseDTO signup(@Valid @RequestBody SignupRequestDTO loginRequestDTO){

        return "";

    }



}
