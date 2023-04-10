package com.springbootsauna.springbootsaunarestapi.user.dto;

import com.springbootsauna.springbootsaunarestapi.util.EGender;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String role;
    private String nationalId;
}
