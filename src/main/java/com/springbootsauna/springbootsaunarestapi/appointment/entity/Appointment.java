package com.springbootsauna.springbootsaunarestapi.appointment.entity;

import com.springbootsauna.springbootsaunarestapi.customer.entity.Customer;
import com.springbootsauna.springbootsaunarestapi.product.entity.Product;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Enumerated(EnumType.STRING)
    private EAppointmentStatus eAppointmentStatus;

}