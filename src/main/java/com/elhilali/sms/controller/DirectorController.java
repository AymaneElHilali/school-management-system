package com.elhilali.sms.controller;

import com.elhilali.sms.dataAcces.dto.LoginRequestDTO;
import com.elhilali.sms.dataAcces.dto.LoginResponseDTO;
import com.elhilali.sms.dataAcces.dto.SignupRequestDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import com.elhilali.sms.service.DirectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @PostMapping("/director/signup")
    public SignupResponseDTO signup(@Valid @RequestBody SignupRequestDTO signupRequestDTO){

        return directorService.signup(signupRequestDTO) ;

    }

    @PostMapping("/director/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        return directorService.login(loginRequestDTO);

    }

}
