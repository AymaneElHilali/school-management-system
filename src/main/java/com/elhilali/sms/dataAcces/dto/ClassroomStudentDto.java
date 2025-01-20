package com.elhilali.sms.dataAcces.dto;

import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.dataAcces.entity.ClassroomStudent;
import com.elhilali.sms.dataAcces.entity.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class ClassroomStudentDto {

    @NotBlank(message = "studentId is Blank")
    private Long studentId;

    @NotBlank(message = "classRoomId is Blank")
    private Long classroomId;

    public ClassroomStudent toEntity(Classroom classroom , Student student){
        return ClassroomStudent.builder()
                .classroom(classroom)
                .student(student)
                .build();
    }

}
