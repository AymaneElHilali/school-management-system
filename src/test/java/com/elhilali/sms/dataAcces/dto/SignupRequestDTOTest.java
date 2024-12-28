package com.elhilali.sms.dataAcces.dto;

import com.elhilali.sms.dataAcces.entity.Role;
import com.elhilali.sms.dataAcces.entity.Sex;
import com.elhilali.sms.dataAcces.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class SignupRequestDTOTest {
       SignupRequestDTO signupRequestDTO = new SignupRequestDTO();

    @Test
    public void toEntityTest(){
        //give
        signupRequestDTO.setEmail("john.doe@example.com");
        signupRequestDTO.setPassword("securePassword123");
        signupRequestDTO.setFirstName("John");
        signupRequestDTO.setLastName("Doe");
        signupRequestDTO.setBirthday(new Date(90, 1, 15)); // January 15, 1990 (deprecated constructor, use Calendar or Instant instead)
        signupRequestDTO.setPhone("0612345678");
        signupRequestDTO.setAddress("1234 Elm Street, Some City, Some Country");
        signupRequestDTO.setJoinDate(new Date()); // Current date
        signupRequestDTO.setSex(Sex.MALE); // Assuming Sex is an Enum
        signupRequestDTO.setRole(Role.student); // Assuming Role is an Enum
        //get
        Student student = signupRequestDTO.toEntity();
        //should
        System.out.println(student);
    }
}
