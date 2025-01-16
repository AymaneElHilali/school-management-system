package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.AddClassroomDto;
import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.dataAcces.repo.ClassroomRepo;
import com.elhilali.sms.exception.ConflictException;
import com.elhilali.sms.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepo classroomRepo;

    //add classroom
    public Classroom addClassroom(AddClassroomDto addClassroomDto){

        //check if a classroom already created by the same name and year
        Classroom isCreated = classroomRepo.findByNameAndYear(addClassroomDto.getName(),addClassroomDto.getYear());

        if (isCreated != null) throw new ConflictException("classroom already created with the same name and year");

        // map from the Dto To Classroom
        Classroom classroom = addClassroomDto.toClassroom();

        //save the classroom
        Classroom savedClassroom = classroomRepo.save(classroom);

        if (savedClassroom == null){

            throw new RuntimeException("creation failed");

        }

        return savedClassroom;

    }


    //delete classroom
    public ResponseEntity<String> deleteClassroom(Long id){
        //check if the classroom exits
        boolean isExist = classroomRepo.existsById(id);
        if (!isExist){
            throw new NotFoundException("no classroom found with the id: " + id);
        }

        //delete the classroom
        classroomRepo.deleteById(id);

        return ResponseEntity.ok("classroom with the id:" + id + " has been deleted successfully.");


    }

    //update classroom
    public String updateClassroom(AddClassroomDto addClassroomDto){


        // check if the classroom is exits
        boolean isExist = classroomRepo.existsById(addClassroomDto.getId());
        if (!isExist){
            throw new NotFoundException("no classroom found with the id: " + addClassroomDto.getId());
        }

        //get the classroom
        Classroom savedClassroom = classroomRepo.getById(addClassroomDto.getId());




        // map from dto to Classroom

        Classroom classroom = addClassroomDto.toClassroomWithId();


        classroomRepo.save(classroom);
        return "pass";

    }


}