package com.springbootsauna.springbootsaunarestapi.user.entity;

import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {


}
