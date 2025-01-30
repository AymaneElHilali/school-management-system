package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.ClassroomStudentDto;
import com.elhilali.sms.dataAcces.dto.ClassroomStudentResponseDto;
import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.dataAcces.entity.ClassroomStudent;
import com.elhilali.sms.dataAcces.entity.Student;
import com.elhilali.sms.dataAcces.repo.ClassroomStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomStudentService {

    private final ClassroomStudentRepo classroomStudentRepo;

    private final ClassroomService classroomService;

    private final StudentService studentService;

    @Autowired
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

    // get all the students from a classRoom
    public List<Student> findStudentsByClassroomId(Long classroomId){

        //check if any classroom exist by that id
        classroomService.findById(classroomId);

        return classroomStudentRepo.findStudentsByClassroomId(classroomId);
    }
}
