package com.springbootsauna.springbootsaunarestapi.customer.dto;

import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.customer.entity.Address;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String nationalId;
    private String phoneNumber;
    private String email;
    private Address address;
    private List<Appointment> appointments;
    private User user;
}
