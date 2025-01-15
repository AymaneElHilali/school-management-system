package com.elhilali.sms.controller;

import com.elhilali.sms.dataAcces.dto.AddClassroomDto;
import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.service.ClassroomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping("/addClassroom")
    public Classroom addClassroom(@Valid @RequestBody AddClassroomDto addClassroomDto){


        return classroomService.addClassroom(addClassroomDto);

    }

    @DeleteMapping("/deleteClassroom/{id}")
    public ResponseEntity<String> deleteClassroom(@PathVariable Long id){

        return classroomService.deleteClassroom(id);

    }
    @PutMapping("/updateClassroom")
    public String updateClassroom(@Valid @RequestBody AddClassroomDto addClassroomDto){


        classroomService.updateClassroom(addClassroomDto);
        return "pass";

    }



}