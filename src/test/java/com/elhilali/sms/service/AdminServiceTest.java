package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.SignupRequestDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import com.elhilali.sms.dataAcces.entity.Role;
import com.elhilali.sms.dataAcces.entity.Sex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    public void signupStudentTest(){

        //give
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        signupRequestDTO.setEmail("Test2@gmail.com");
        signupRequestDTO.setPassword("securePassword123@");
        signupRequestDTO.setFirstName("John");
        signupRequestDTO.setLastName("Doe");
        signupRequestDTO.setBirthday(new Date(2006,06,06));
        signupRequestDTO.setPhone("0612345678");
        signupRequestDTO.setAddress("1234 Elm Street, Some City, Some Country");
        signupRequestDTO.setJoinDate(new Date(2025,01,17));
        signupRequestDTO.setSex(Sex.MALE);
        signupRequestDTO.setRole(Role.student);

        SignupResponseDTO signupResponseDTO = adminService.signupStudent(signupRequestDTO);


        //should
        SignupResponseDTO result = new SignupResponseDTO();
        result.setEmail("Test@gmail.com");
        result.setMessage("Signup successful");
        assertEquals(result,signupResponseDTO);

    }



    @Test
    public void signupTeacherTest(){

        //give
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        signupRequestDTO.setEmail("Test1@gmail.com");
        signupRequestDTO.setPassword("securePassword123@");
        signupRequestDTO.setFirstName("John");
        signupRequestDTO.setLastName("Doe");
        signupRequestDTO.setBirthday(new Date(2006,06,06));
        signupRequestDTO.setPhone("0612345678");
        signupRequestDTO.setAddress("1234 Elm Street, Some City, Some Country");
        signupRequestDTO.setJoinDate(new Date(2025,01,17));
        signupRequestDTO.setSex(Sex.MALE);
        signupRequestDTO.setRole(Role.teacher);

        SignupResponseDTO signupResponseDTO = adminService.signupTeacher(signupRequestDTO);


        //should
        SignupResponseDTO result = new SignupResponseDTO();
        result.setEmail("Test1@gmail.com");
        result.setMessage("Signup successful");
        assertEquals(result,signupResponseDTO);

    }



}
