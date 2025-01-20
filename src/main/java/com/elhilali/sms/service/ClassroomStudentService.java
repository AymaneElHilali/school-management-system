package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.ClassroomStudentDto;
import com.elhilali.sms.dataAcces.dto.ClassroomStudentResponseDto;
import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.dataAcces.entity.ClassroomStudent;
import com.elhilali.sms.dataAcces.entity.Student;
import com.elhilali.sms.dataAcces.repo.ClassroomStudentRepo;
import org.springframework.stereotype.Service;

@Service
public class ClassroomStudentService {

    private final ClassroomStudentRepo classroomStudentRepo;

    private final ClassroomService classroomService;

    private final StudentService studentService;

    public ClassroomStudentService(ClassroomStudentRepo classroomStudentRepo,StudentService studentService,ClassroomService classroomService) {
        this.classroomStudentRepo = classroomStudentRepo;
        this.studentService = studentService;
        this.classroomService = classroomService;
    }


    //add student to classroom
    public ClassroomStudentResponseDto addStudentToClassroom(ClassroomStudentDto classroomStudentDto){
        // get the student
        Student student = studentService.findById(classroomStudentDto.getStudentId());

        // get the classroom
        Classroom classroom = classroomService.findById(classroomStudentDto.getClassroomId());

        // check if the student already in this classroom

        //from dto to classroomStudent
        ClassroomStudent classroomStudent = classroomStudentDto.toEntity(classroom,student);

        //save


        return classroomStudentRepo.save(classroomStudent).toDto();

    }
}
