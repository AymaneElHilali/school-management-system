package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.dataAcces.entity.Admin;
import com.elhilali.sms.dataAcces.entity.Student;
import com.elhilali.sms.dataAcces.entity.User;
import com.elhilali.sms.dataAcces.repo.AdminRepo;
import com.elhilali.sms.exception.ConflictException;
import com.elhilali.sms.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public UpdateBySelfDto updateBySelf(UpdateBySelfDto updateBySelfDto){

        //check if we have a user with that id
        Long id = updateBySelfDto.getId();
        Optional<Admin> adminOptional = adminRepo.findById(id);
        // throw the exception if the admin is empty
        if (adminOptional.isEmpty()){
            throw new NotFoundException("no user with the id :"+id);
        }
        Admin oldAdmin = adminOptional.get();
        // send the old admin to the dto to get the new one
        Admin newAdmin = (Admin) updateBySelfDto.toUser(oldAdmin);

        adminRepo.save(newAdmin);
        return newAdmin.toUpdateBySelfDto();

    }

    public ResponseEntity<String> deleteAcount(Long id){

        // check if the user exist
        boolean isExist = adminRepo.existsById(id);

        if (!isExist) throw new NotFoundException("no user with the id :"+id);

        adminRepo.deleteById(id);

        return ResponseEntity.ok("the acount with the id:" + id + " has been deleted successfully.");

    }
}
