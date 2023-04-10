package com.springbootsauna.springbootsaunarestapi.customer.entity;

import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "national_identification", nullable = false)
    private String nationalId;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    private String email;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointments;
    private UUID user_id;
}
