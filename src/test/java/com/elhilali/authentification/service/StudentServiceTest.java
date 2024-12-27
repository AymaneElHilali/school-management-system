//package com.elhilali.authentification.service;
//
//import com.elhilali.authentification.dataAcces.dto.SignupRequestDTO;
//import com.elhilali.authentification.dataAcces.dto.SignupResponseDTO;
//import com.elhilali.authentification.dataAcces.entity.Role;
//import com.elhilali.authentification.dataAcces.entity.Sex;
//import com.elhilali.authentification.dataAcces.repo.StudentRepo;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//
//@SpringBootTest
//public class StudentServiceTest {
//
//    StudentService studentService = new StudentService();
//
//
//    @Test
//    public void studentServiceTest(){
//        //give
//
//        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
//
//        signupRequestDTO.setEmail("john.doe@example.com");
//        signupRequestDTO.setPassword("securePassword123");
//        signupRequestDTO.setFirstName("John");
//        signupRequestDTO.setLastName("Doe");
//        signupRequestDTO.setBirthday(new Date(90, 1, 15)); // January 15, 1990 (deprecated constructor, use Calendar or Instant instead)
//        signupRequestDTO.setPhone("0612345678");
//        signupRequestDTO.setAddress("1234 Elm Street, Some City, Some Country");
//        signupRequestDTO.setJoinDate(new Date()); // Current date
//        signupRequestDTO.setSex(Sex.MALE); // Assuming Sex is an Enum
//        signupRequestDTO.setRole(Role.student); // Assuming Role is an Enum
//
//        //get
//
//        SignupResponseDTO signupResponseDTO = studentService.signup(signupRequestDTO);
//        //should
//        System.out.println(signupResponseDTO);
//    }
//}
