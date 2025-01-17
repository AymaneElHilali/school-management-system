package com.elhilali.sms.dataAcces.entity;


import com.elhilali.sms.dataAcces.dto.LoginResponseDTO;
import com.elhilali.sms.dataAcces.dto.SignupResponseDTO;
import com.elhilali.sms.dataAcces.dto.UpdateByOther;
import com.elhilali.sms.dataAcces.dto.UpdateBySelfDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@SuperBuilder
@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private String  phone;
    @Column(length = 500)
    private String address;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private Role role;




    public SignupResponseDTO ToSignupResponseDTO(){

        return SignupResponseDTO.builder()
                .email(this.getEmail())
                .message("Signup successful")
                .build();

    }

    public LoginResponseDTO ToLoginResponseDTO(){

        return LoginResponseDTO.builder()
                .email(this.getEmail())
                .id(this.getId())
                .role(this.getRole())
                .build();
    }

    public UpdateBySelfDto toUpdateBySelfDto(){

        return UpdateBySelfDto.builder()
                .id(this.getId())
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

    public UpdateByOther toUpdateByOther(){

        return UpdateByOther.builder()
                .id(this.getId())
                .email(this.getEmail())
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



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + this.role.name());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
