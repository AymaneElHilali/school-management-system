package com.elhilali.authentification.dataAcces.dto;

import com.elhilali.authentification.dataAcces.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseDTO {
    private Long id;
    private String email;
    private Role role;
    private String jwt;
}
