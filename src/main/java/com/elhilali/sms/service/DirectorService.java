package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.LoginRequestDTO;
import com.elhilali.sms.dataAcces.dto.LoginResponseDTO;
import com.elhilali.sms.dataAcces.dto.SignupRequestDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import com.elhilali.sms.dataAcces.entity.Director;
import com.elhilali.sms.dataAcces.entity.User;
import com.elhilali.sms.dataAcces.repo.DirectorRepo;
import com.elhilali.sms.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    @Autowired
    UserService userService;

    @Autowired
    DirectorRepo directorRepo;

    @Autowired
    JwtService jwtService;

    public SignupResponseDTO signup(SignupRequestDTO signupRequestDTO){

        //check if the email already used
        if (userService.emailAlreadyUsed(signupRequestDTO.getEmail())){
            throw new ConflictException("Email already Used!");
        }

        // map from Dto to Director
        Director mapedDirector = signupRequestDTO.toDirector();
        // Save the Director
        Director savedDirector = directorRepo.save(mapedDirector);

        if (savedDirector.getEmail()==null){
            throw new ConflictException("signup failed");
        }

        // map from director to the DTO that we will return
        return savedDirector.ToSignupResponseDTO();


    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){

        // get the Director by the email
        User director = directorRepo.findByEmail(loginRequestDTO.getEmail());

        // check the director is not null , and if they have the sam password
        if (director!=null && loginRequestDTO.getPassword().equals(director.getPassword())){

            LoginResponseDTO loginResponseDTO = director.ToLoginResponseDTO();
            String token = jwtService.generateToken(director.getEmail(),director.getRole());
            loginResponseDTO.setJwt(token);
            return loginResponseDTO;

        }
        else {
            throw new ConflictException("wrong email or password");
        }


    }
}
