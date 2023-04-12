package com.springbootsauna.springbootsaunarestapi.appointment.service;

import com.springbootsauna.springbootsaunarestapi.appointment.dto.AppointmentDto;
import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IAppointmentService {
        ResponseObject createAppointment(AppointmentDto appointmentDto);

        ResponseObject processAppointment(UUID user_id, UUID appointment_id, EAppointmentStatus appointmentStatus);

        ResponseObject getAppointment(UUID id);
        Page<Appointment> findAllAppointment(Integer pageNumber, Integer pageSize);


}
