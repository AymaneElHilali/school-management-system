package com.elhilali.sms.controller;

import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.service.StudentService;
import com.elhilali.sms.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/teacher/signup")
    public SignupResponseDTO signup(@Valid @RequestBody SignupRequestDTO signupRequestDTO){
        return teacherService.signup(signupRequestDTO);
    }

    @PostMapping("/teacher/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        return teacherService.login(loginRequestDTO);

    }

    @PutMapping("/teacher/update")
    public UpdateBySelfDto updateBySelf(@Valid @RequestBody UpdateBySelfDto updateBySelfDto){

        return teacherService.updateBySelf(updateBySelfDto);

    }
}
