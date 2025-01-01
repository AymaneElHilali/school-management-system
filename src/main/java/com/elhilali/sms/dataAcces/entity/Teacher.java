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
@Table(name = "Teacher")
public class Teacher extends User{

}
