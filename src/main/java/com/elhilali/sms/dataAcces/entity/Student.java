package com.elhilali.sms.dataAcces.entity;

import com.elhilali.sms.dataAcces.dto.LoginResponseDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Student")
public class Student extends User{

    public SignupResponseDTO ToSignupResponseDTO(){

        return SignupResponseDTO.builder()
                .email(this.getEmail())
                .message("Signup successful")
                .build();

    }
    public LoginResponseDTO ToLoginResponseDTO(){

        return LoginResponseDTO.builder()
                .email(this.getEmail())
                .id(this.getId())
                .role(Role.student)
                .build();
    }

}
