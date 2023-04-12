package com.springbootsauna.springbootsaunarestapi.appointment.entity;

import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, UUID> {
//    List<Appointment> findAllByEAppointmentStatusAndUserERole(EAppointmentStatus eAppointmentStatus, ERole role);


}
