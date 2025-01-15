package com.elhilali.sms.dataAcces.dto;

import com.elhilali.sms.dataAcces.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBySelfDto extends SignupRequestDTO{

    Long id;

    public User toUser(User user) {
        user.setId(this.getId());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        user.setBirthday(this.getBirthday());
        user.setPhone(this.getPhone());
        user.setAddress(this.getAddress());
        user.setJoinDate(this.getJoinDate());
        user.setSex(this.getSex());
        user.setRole(this.getRole());
        return user;
    }

}
