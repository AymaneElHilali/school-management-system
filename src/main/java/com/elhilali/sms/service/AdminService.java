package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.LoginRequestDTO;
import com.elhilali.sms.dataAcces.dto.LoginResponseDTO;
import com.elhilali.sms.dataAcces.dto.SignupRequestDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import com.elhilali.sms.dataAcces.entity.Admin;
import com.elhilali.sms.dataAcces.entity.User;
import com.elhilali.sms.dataAcces.repo.AdminRepo;
import com.elhilali.sms.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    JwtService jwtService;

    public SignupResponseDTO signup(SignupRequestDTO signupRequestDTO){

        //check if the email already used
        if (userService.emailAlreadyUsed(signupRequestDTO.getEmail())){
            throw new ConflictException("Email already Used!");
        }

        // map from Dto to Admin
        Admin mapedAdmin = signupRequestDTO.toAdmin();
        // Save the Admin
        Admin savedAdmin = adminRepo.save(mapedAdmin);

        if (savedAdmin.getEmail()==null){
            throw new ConflictException("signup failed");
        }

        // map from admin to the DTO that we will return
        return savedAdmin.ToSignupResponseDTO();


    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){

        // get the Admin by the email
        User admin = adminRepo.findByEmail(loginRequestDTO.getEmail());

        // check the admin is not null , and if they have the sam password
        if (admin!=null && loginRequestDTO.getPassword().equals(admin.getPassword())){

            LoginResponseDTO loginResponseDTO = admin.ToLoginResponseDTO();
            String token = jwtService.generateToken(admin.getEmail(),admin.getRole());
            loginResponseDTO.setJwt(token);
            return loginResponseDTO;

        }
        else {
            throw new ConflictException("wrong email or password");
        }


    }
}
