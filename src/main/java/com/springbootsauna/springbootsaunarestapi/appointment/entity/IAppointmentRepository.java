package com.springbootsauna.springbootsaunarestapi.appointment.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, UUID> {

}
