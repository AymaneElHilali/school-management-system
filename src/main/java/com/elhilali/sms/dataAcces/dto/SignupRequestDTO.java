package com.elhilali.sms.dataAcces.dto;

import com.elhilali.sms.dataAcces.entity.Role;
import com.elhilali.sms.dataAcces.entity.Sex;
import com.elhilali.sms.dataAcces.entity.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDTO extends LoginRequestDTO {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @NotNull(message = "Birthday cannot be null")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^0[67][0-9]{8}$", message = "Invalid phone number")
    private String phone;

    @Size(max = 500, message = "Address cannot exceed 500 characters")
    @Column(length = 500)
    private String address; // Can be null or empty

    @NotNull(message = "Join date cannot be null")
    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @NotNull(message = "Sex cannot be null")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull(message = "Role cannot be null")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Student toEntity() {
        return (Student) Student.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .birthday(this.getBirthday())
                .phone(this.getPhone())
                .address(this.getAddress())
                .joinDate(this.getJoinDate())
                .sex(this.getSex())
                .role(this.getRole())
                .build();
    }
}
