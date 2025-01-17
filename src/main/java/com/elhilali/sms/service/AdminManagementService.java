package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.SignupRequestDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminManagementService {

    private final StudentService studentService;

    @Autowired
    public AdminManagementService(StudentService studentService) {
        this.studentService = studentService;
    }

    public SignupResponseDTO signupStudent(SignupRequestDTO signupRequestDTO){
        return studentService.signup(signupRequestDTO);
    }

    public ResponseEntity<String> deleteStudentAcount(Long id) {
        return studentService.deleteAcount(id);
    }
}
