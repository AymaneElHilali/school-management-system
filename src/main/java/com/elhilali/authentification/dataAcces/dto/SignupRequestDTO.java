package com.elhilali.authentification.dataAcces.dto;

import com.elhilali.authentification.dataAcces.entity.Role;
import com.elhilali.authentification.dataAcces.entity.Sex;
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
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,}$", message = "Phone number must be valid and at least 7 characters long")
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
