package com.elhilali.sms.controller;

import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.service.DirectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/director/update")
    public UpdateBySelfDto updateBySelf(@Valid @RequestBody UpdateBySelfDto updateBySelfDto){

        return directorService.updateBySelf(updateBySelfDto);

    }
    @DeleteMapping("/director/delete/{id}")
    public ResponseEntity<String> deleteAcount(@PathVariable Long id){

        return directorService.deleteAcount(id);

    }

}
