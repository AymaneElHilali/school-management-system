package com.elhilali.sms.dataAcces.dto;

import com.elhilali.sms.dataAcces.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    @Email(message = "Invalid email format")
    private String email;

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



}
