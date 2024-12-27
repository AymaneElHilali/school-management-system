package com.elhilali.authentification.dataAcces.entity;

import com.elhilali.authentification.dataAcces.dto.SignupResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


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

}
