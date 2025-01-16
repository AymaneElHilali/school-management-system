package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.dataAcces.entity.Teacher;
import com.elhilali.sms.dataAcces.entity.Teacher;
import com.elhilali.sms.dataAcces.entity.User;
import com.elhilali.sms.dataAcces.repo.TeacherRepo;
import com.elhilali.sms.exception.ConflictException;
import com.elhilali.sms.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    UserService userService;


    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    JwtService jwtService;

    public SignupResponseDTO signup(SignupRequestDTO signupRequestDTO){


        //check if the email already used
        if (userService.emailAlreadyUsed(signupRequestDTO.getEmail())){
            throw new ConflictException("Email already Used!");
        }

        // map from Dto to Teacher
        Teacher mapedteacher = signupRequestDTO.toTeacher();
        System.out.println(mapedteacher);
        // Save the teacher
        Teacher savedTeacher = teacherRepo.save(mapedteacher);
        System.out.println(savedTeacher);
        if (savedTeacher.getEmail()==null){
            throw new ConflictException("signup failed");
        }

        // map from teacher to the DTO that we will return
        return savedTeacher.ToSignupResponseDTO();
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){

        // get the teatcher by the email
        User teacher = teacherRepo.findByEmail(loginRequestDTO.getEmail());

        // check the teacher is not null , and if they have the sam password
        if (teacher!=null && loginRequestDTO.getPassword().equals(teacher.getPassword())){

            LoginResponseDTO loginResponseDTO = teacher.ToLoginResponseDTO();
            String token = jwtService.generateToken(teacher.getEmail(),teacher.getRole());
            loginResponseDTO.setJwt(token);
            return loginResponseDTO;

        }
        else {
            throw new ConflictException("wrong email or password");
        }


    }

    public UpdateBySelfDto updateBySelf(UpdateBySelfDto updateBySelfDto){

        //check if we have a user with that id
        Long id = updateBySelfDto.getId();
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        // throw the exception if the teacher is empty
        if (teacherOptional.isEmpty()){
            throw new NotFoundException("no user with the id :"+id);
        }
        Teacher oldTeacher = teacherOptional.get();
        // send the old teacher to the dto to get the new one
        Teacher newTeacher = (Teacher) updateBySelfDto.toUser(oldTeacher);

        teacherRepo.save(newTeacher);
        return newTeacher.toUpdateBySelfDto();
    }
    public ResponseEntity<String> deleteAcount(Long id){

        // check if the user exist
        boolean isExist = teacherRepo.existsById(id);

        if (!isExist) throw new NotFoundException("no user with the id :"+id);

        teacherRepo.deleteById(id);

        return ResponseEntity.ok("the acount with the id:" + id + " has been deleted successfully.");

    }
}
