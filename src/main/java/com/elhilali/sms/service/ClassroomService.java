package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.AddClassroomDto;
import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.dataAcces.repo.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepo classroomRepo;

    public Classroom addClassroom(AddClassroomDto addClassroomDto){

        // map from the Dto To Classroom
        Classroom classroom = addClassroomDto.toClassroom();

        //save the classroom
        Classroom savedClassroom = classroomRepo.save(classroom);

        if (savedClassroom == null){

            throw new RuntimeException("creation failed");

        }

        return savedClassroom;


    }
}
