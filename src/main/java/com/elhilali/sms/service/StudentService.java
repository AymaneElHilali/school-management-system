package com.elhilali.sms.service;

import com.elhilali.sms.dataAcces.dto.*;
import com.elhilali.sms.dataAcces.entity.Student;
import com.elhilali.sms.dataAcces.entity.User;
import com.elhilali.sms.dataAcces.repo.StudentRepo;
import com.elhilali.sms.exception.ConflictException;
import com.elhilali.sms.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {


    private final UserService userService;


    private final StudentRepo studentRepo;


    private final JwtService jwtService;

    @Autowired
    public StudentService(UserService userService, StudentRepo studentRepo, JwtService jwtService) {
        this.userService = userService;
        this.studentRepo = studentRepo;
        this.jwtService = jwtService;
    }

    public SignupResponseDTO signup(SignupRequestDTO signupRequestDTO){

        //check if the email already used
        if (userService.emailAlreadyUsed(signupRequestDTO.getEmail())){
            throw new ConflictException("Email already Used!");
        }

        // map from Dto to Student
        Student mapedStudent = (Student) signupRequestDTO.toStudent();
        // Save the Student
        Student savedStudent = studentRepo.save(mapedStudent);

        if (savedStudent.getEmail()==null){
            throw new ConflictException("signup failed");
        }

        // map from student to the DTO that we will return
        return savedStudent.ToSignupResponseDTO();


    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){

        // get the Student by the email
        User student = studentRepo.findByEmail(loginRequestDTO.getEmail());

        // check the student is not null , and if they have the sam password
        if (student!=null && loginRequestDTO.getPassword().equals(student.getPassword())){

            LoginResponseDTO loginResponseDTO = student.ToLoginResponseDTO();
            String token = jwtService.generateToken(student.getEmail(),student.getRole());
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
       Optional<Student> studentOptional = studentRepo.findById(id);
       // throw the exception if the student is empty
       if (studentOptional.isEmpty()){
           throw new NotFoundException("no user with the id :"+id);
       }
       Student oldStudent = studentOptional.get();
        //throw the exception if the new email already used
        if (!Objects.equals(updateBySelfDto.getEmail(), oldStudent.getEmail()) && studentRepo.existsByEmail(updateBySelfDto.getEmail())){
            throw new ConflictException("email already used");
        }
       // send the old student to the dto to get the new one
       Student newStudent = (Student) updateBySelfDto.toUser(oldStudent);

       studentRepo.save(newStudent);
       return newStudent.toUpdateBySelfDto();

    }

    public UpdateByOther updateByOther(UpdateByOther updateByOther){

        //check if we have a user with that id
        Long id = updateByOther.getId();
        Optional<Student> studentOptional = studentRepo.findById(id);
        // throw the exception if the student is empty
        if (studentOptional.isEmpty()){
            throw new NotFoundException("no user with the id :"+id);
        }
        Student oldStudent = studentOptional.get();
        // send the old student to the dto to get the new one
        //throw the exception if the new email already used
        if (!Objects.equals(updateByOther.getEmail(), oldStudent.getEmail()) && studentRepo.existsByEmail(updateByOther.getEmail())){
            throw new ConflictException("email already used");
        }
        Student newStudent = (Student) updateByOther.toUser(oldStudent);

        studentRepo.save(newStudent);
        return newStudent.toUpdateByOther();

    }



    public ResponseEntity<String> deleteAcount( Long id){

        // check if the user exist
        boolean isExist = studentRepo.existsById(id);

        if (!isExist) throw new NotFoundException("no user with the id :"+id);

        studentRepo.deleteById(id);

        return ResponseEntity.ok("the acount with the id:" + id + " has been deleted successfully.");

    }

    //get student by id
    public Student findById(Long id){

        Optional<Student> student = studentRepo.findById(id);

        //trow Student Not found
        if (student.isEmpty()) throw new NotFoundException("0 student found with the id :"+id);

        return student.get();
    }
}
