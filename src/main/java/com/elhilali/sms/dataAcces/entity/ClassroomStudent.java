package com.elhilali.sms.dataAcces.entity;

import com.elhilali.sms.dataAcces.dto.ClassroomStudentResponseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ClassroomStudent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassroomStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    public ClassroomStudentResponseDto toDto(){
        return ClassroomStudentResponseDto.builder()
                .classroomId(this.getClassroom().getId())
                .studentId(this.getStudent().getId())
                .message("the student added successfully to the classroom")
                .build();
    }
}