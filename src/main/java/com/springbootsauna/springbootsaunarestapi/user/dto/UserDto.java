package com.springbootsauna.springbootsaunarestapi.user.dto;

import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.util.EGender;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
public class UserDto {
    private String password;
    private String firstName;
    private String lastName;
    private EGender gender;
    private String phoneNumber;
    private ERole role;
    private String nationalId;
//    private List<Appointment> appointments;

}
