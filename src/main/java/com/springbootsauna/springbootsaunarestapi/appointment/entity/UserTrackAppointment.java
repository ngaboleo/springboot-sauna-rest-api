package com.springbootsauna.springbootsaunarestapi.appointment.entity;


import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_track_appointment")
public class UserTrackAppointment {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID user_id;
    private UUID appointment_id;
    @Enumerated(EnumType.STRING)
    private EAppointmentStatus appointmentStatus;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;
}
