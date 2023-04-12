package com.springbootsauna.springbootsaunarestapi.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.util.EGender;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private ERole role;
    @Column(name = "national_id")
    private String nationalId;
//    @OneToMany(mappedBy = "user")
//    private List<Appointment> appointments;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;

}
