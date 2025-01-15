//package com.elhilali.sms.dataAcces.dto;
//
//import com.elhilali.sms.dataAcces.entity.Admin;
//import com.elhilali.sms.dataAcces.entity.Director;
//import com.elhilali.sms.dataAcces.entity.Student;
//import com.elhilali.sms.dataAcces.entity.Teacher;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//public class UpdateByOtherUserDto extends UserData{
//
//    public Student toStudent() {
//        return (Student) Student.builder()
//                .email(this.getEmail())
//                .firstName(this.getFirstName())
//                .lastName(this.getLastName())
//                .birthday(this.getBirthday())
//                .phone(this.getPhone())
//                .address(this.getAddress())
//                .joinDate(this.getJoinDate())
//                .sex(this.getSex())
//                .role(this.getRole())
//                .build();
//    }
//    public Teacher toTeacher() {
//        return (Teacher) Teacher.builder()
//                .email(this.getEmail())
//                .firstName(this.getFirstName())
//                .lastName(this.getLastName())
//                .birthday(this.getBirthday())
//                .phone(this.getPhone())
//                .address(this.getAddress())
//                .joinDate(this.getJoinDate())
//                .sex(this.getSex())
//                .role(this.getRole())
//                .build();
//    }
//    public Admin toAdmin() {
//        return (Admin) Admin.builder()
//                .email(this.getEmail())
//                .firstName(this.getFirstName())
//                .lastName(this.getLastName())
//                .birthday(this.getBirthday())
//                .phone(this.getPhone())
//                .address(this.getAddress())
//                .joinDate(this.getJoinDate())
//                .sex(this.getSex())
//                .role(this.getRole())
//                .build();
//    }
//    public Director toDirector() {
//        return (Director) Director.builder()
//                .email(this.getEmail())
//                .firstName(this.getFirstName())
//                .lastName(this.getLastName())
//                .birthday(this.getBirthday())
//                .phone(this.getPhone())
//                .address(this.getAddress())
//                .joinDate(this.getJoinDate())
//                .sex(this.getSex())
//                .role(this.getRole())
//                .build();
//    }
//}
