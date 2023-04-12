package com.springbootsauna.springbootsaunarestapi.appointment.dto;

import com.springbootsauna.springbootsaunarestapi.product.entity.Product;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class AppointmentDto {
    private LocalDate startTime;
    private LocalDate endTime;
    private UUID user_id;
    private List<Product> products;
    private EAppointmentStatus eAppointmentStatus;
}
