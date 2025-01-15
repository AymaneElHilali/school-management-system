package com.elhilali.sms.dataAcces.dto;


import com.elhilali.sms.dataAcces.entity.Classroom;
import com.elhilali.sms.dataAcces.entity.ClassroomStudent;
import com.elhilali.sms.dataAcces.entity.FieldOfStudy;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddClassroomDto {

    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private FieldOfStudy fieldOfStudy;

    @Pattern(regexp = "\\d{4}-\\d{4}", message = "Year must be in the format YYYY-YYYY")
    private String year;


    public Classroom toClassroom(){
        return Classroom.builder()
                .name(this.name)
                .fieldOfStudy(this.fieldOfStudy)
                .year(this.year)
                .build();
    }
    public Classroom toClassroomWithId(){
        return Classroom.builder()
                .id(this.id)
                .name(this.name)
                .fieldOfStudy(this.fieldOfStudy)
                .year(this.year)
                .build();
    }

}