package com.elhilali.sms.dataAcces.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Admin")
public class Admin extends User{

}
