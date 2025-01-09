package com.elhilali.sms.controller;

import com.elhilali.sms.dataAcces.dto.AddClassroomDto;
import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.service.ClassroomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping("/addClassroom")
    public Classroom addClassroom(@Valid @RequestBody AddClassroomDto addClassroomDto){

        return classroomService.addClassroom(addClassroomDto);

    }

}
