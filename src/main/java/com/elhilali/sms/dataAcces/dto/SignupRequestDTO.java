package com.elhilali.sms.dataAcces.dto;

import com.elhilali.sms.dataAcces.entity.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SignupRequestDTO extends UserData {

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{9,}$",
            message = "Password must contain at least 9 characters, one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;



    public User toUser() {
        return (User) User.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .birthday(this.getBirthday())
                .phone(this.getPhone())
                .address(this.getAddress())
                .joinDate(this.getJoinDate())
                .sex(this.getSex())
                .role(this.getRole())
                .build();
    }
    public Student toStudent() {
        return (Student) Student.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .birthday(this.getBirthday())
                .phone(this.getPhone())
                .address(this.getAddress())
                .joinDate(this.getJoinDate())
                .sex(this.getSex())
                .role(this.getRole())
                .build();
    }
    public Teacher toTeacher() {
        return (Teacher) Teacher.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .birthday(this.getBirthday())
                .phone(this.getPhone())
                .address(this.getAddress())
                .joinDate(this.getJoinDate())
                .sex(this.getSex())
                .role(this.getRole())
                .build();
    }
    public Admin toAdmin() {
        return (Admin) Admin.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .birthday(this.getBirthday())
                .phone(this.getPhone())
                .address(this.getAddress())
                .joinDate(this.getJoinDate())
                .sex(this.getSex())
                .role(this.getRole())
                .build();
    }
    public Director toDirector() {
        return (Director) Director.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .birthday(this.getBirthday())
                .phone(this.getPhone())
                .address(this.getAddress())
                .joinDate(this.getJoinDate())
                .sex(this.getSex())
                .role(this.getRole())
                .build();
    }
}
