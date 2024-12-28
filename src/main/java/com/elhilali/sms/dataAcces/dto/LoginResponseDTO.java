package com.elhilali.sms.dataAcces.dto;

import com.elhilali.sms.dataAcces.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginResponseDTO {
    private Long id;
    private String email;
    private Role role;
    private String jwt;
}
