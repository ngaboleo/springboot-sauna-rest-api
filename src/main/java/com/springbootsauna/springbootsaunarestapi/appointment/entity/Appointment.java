package com.springbootsauna.springbootsaunarestapi.appointment.entity;

import com.springbootsauna.springbootsaunarestapi.product.entity.Product;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate startTime;
    private LocalDate endTime;
    private UUID user_id;
    @ManyToMany
    @JoinTable(
            name = "appointment_product",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    private EAppointmentStatus eAppointmentStatus;

}