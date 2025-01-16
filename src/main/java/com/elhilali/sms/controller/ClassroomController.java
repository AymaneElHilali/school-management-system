package com.elhilali.sms.controller;

import com.elhilali.sms.dataAcces.dto.ClassroomDto;
import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.service.ClassroomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping("/addClassroom")
    public Classroom addClassroom(@Valid @RequestBody ClassroomDto classroomDto){


        return classroomService.addClassroom(classroomDto);

    }

    @DeleteMapping("/deleteClassroom/{id}")
    public ResponseEntity<String> deleteClassroom(@PathVariable Long id){

        return classroomService.deleteClassroom(id);

    }
    @PutMapping("/updateClassroom")
    public ClassroomDto updateClassroom(@Valid @RequestBody ClassroomDto classroomDto){


        return classroomService.updateClassroom(classroomDto);


    }



}