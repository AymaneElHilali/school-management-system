package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.dataAcces.entity.ClassroomStudent;
import com.elhilali.sms.dataAcces.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManagementService {

    private final ClassroomService classroomService;

    private final ClassroomStudentService classroomStudentService;

    private final StudentService studentService;

    private final TeacherService teacherService;

    @Autowired
    public AdminManagementService(StudentService studentService , TeacherService teacherService, ClassroomService classroomService,ClassroomStudentService classroomStudentService) {

        this.studentService = studentService;
        this.teacherService = teacherService;
        this.classroomService = classroomService;
        this.classroomStudentService = classroomStudentService;
    }

    //student
    public SignupResponseDTO signupStudent(SignupRequestDTO signupRequestDTO){
        return studentService.signup(signupRequestDTO);
    }

    public UpdateByOther updateStudent(UpdateByOther updateByOther){
        return studentService.updateByOther(updateByOther);
    }

    public ResponseEntity<String> deleteStudentAcount(Long id) {
        return studentService.deleteAcount(id);
    }



    //teacher
    public SignupResponseDTO signupTeacher(SignupRequestDTO signupRequestDTO){
        return teacherService.signup(signupRequestDTO);
    }

    public UpdateByOther updateTeacher(UpdateByOther updateByOther){
        return teacherService.updateByOther(updateByOther);
    }

    public ResponseEntity<String> deleteTeacherAcount(Long id) {
        return teacherService.deleteAcount(id);
    }


    //classroom

    //add
    public ClassroomDto addClassroom(ClassroomDto classroomDto){

        return classroomService.addClassroom(classroomDto);

    }

    //add Student to a Classroom
    public ClassroomStudentResponseDto addStudentToClassroom(ClassroomStudentDto classroomStudentDto){
        return classroomStudentService.addStudentToClassroom(classroomStudentDto);
    }

    // get all the students from a classRoom
    public List<Student> findStudentsByClassroomId(Long classroomId){
        return classroomStudentService.findStudentsByClassroomId(classroomId);
    }
}
