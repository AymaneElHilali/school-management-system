package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.repo.ClassroomStudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClassroomStudentServiceTest {

    @Autowired
    ClassroomStudentService classroomStudentService;

    @Test
    void findStudentsByClassroomId() {

        System.out.println(classroomStudentService.findStudentsByClassroomId(1L));

    }
}