package com.elhilali.sms.controller;

import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin/signup")
    public SignupResponseDTO signup(@Valid @RequestBody SignupRequestDTO signupRequestDTO){

        return adminService.signup(signupRequestDTO) ;

    }

    @PostMapping("/admin/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        return adminService.login(loginRequestDTO);

    }

    @PutMapping("/admin/update")
    public UpdateBySelfDto updateBySelf(@Valid @RequestBody UpdateBySelfDto updateBySelfDto){

        return adminService.updateBySelf(updateBySelfDto);

    }
}
