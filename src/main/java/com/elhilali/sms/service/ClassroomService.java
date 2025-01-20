package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.ClassroomDto;
import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.dataAcces.repo.ClassroomRepo;
import com.elhilali.sms.exception.ConflictException;
import com.elhilali.sms.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomService {


    private final ClassroomRepo classroomRepo;

    @Autowired
    public ClassroomService(ClassroomRepo classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    //add classroom
    public ClassroomDto addClassroom(ClassroomDto classroomDto){

        //check if a classroom already created by the same name and year
        Classroom isCreated = classroomRepo.findByNameAndYear(classroomDto.getName(), classroomDto.getYear());

        if (isCreated != null) throw new ConflictException("classroom already created with the same name and year");

        // map from the Dto To Classroom
        Classroom classroom = classroomDto.toClassroom();

        //save the classroom
        Classroom savedClassroom = classroomRepo.save(classroom);

        if (savedClassroom == null){

            throw new RuntimeException("creation failed");

        }

        return savedClassroom.toDto();

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
    public ClassroomDto updateClassroom(ClassroomDto classroomDto){


        // check if the classroom is exits
        boolean isExist = classroomRepo.existsById(classroomDto.getId());
        if (!isExist){
            throw new NotFoundException("no classroom found with the id: " + classroomDto.getId());
        }

        //get the classroom
        Classroom savedClassroom = classroomRepo.getById(classroomDto.getId());



        // map from dto to new Classroom
        Classroom classroom = classroomDto.updateClassroom(savedClassroom);
        //save
        Classroom newClassroom = classroomRepo.save(classroom);
        // map to dto to return it
        return newClassroom.toDto();



    }

    //get Classroom by id
    public Classroom findById(Long id){

       Optional<Classroom> classroom = classroomRepo.findById(id);

       if (classroom.isEmpty()) throw new NotFoundException("Classroom with the id : "+id+"NotFound");

       return classroom.get();
    }


}