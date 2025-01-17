package com.elhilali.sms.controller;

import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {


    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

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
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<String> deleteAcount(@PathVariable Long id){

        return adminService.deleteAcount(id);

    }
    @PostMapping("/admin/student/signup")
    public SignupResponseDTO signupStudent(@Valid @RequestBody SignupRequestDTO signupRequestDTO){

        return adminService.signupStudent(signupRequestDTO) ;

    }
    @DeleteMapping("/admin/student/delete/{id}")
    public ResponseEntity<String> deleteStudentAcount(@PathVariable Long id){

        return adminService.deleteStudentAcount(id);

    }
}
