package com.elhilali.sms.dataAcces.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name = "classroom",uniqueConstraints = @UniqueConstraint(columnNames = {"name","year"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private FieldOfStudy fieldOfStudy;

    //Year must be in the format YYYY-YYYY
    private String year;

    @OneToMany(mappedBy = "classroom")
    private List<ClassroomStudent> classroomStudents = new ArrayList<>();


}