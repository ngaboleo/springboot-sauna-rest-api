package com.springbootsauna.springbootsaunarestapi.appointment.service;

import com.springbootsauna.springbootsaunarestapi.appointment.dto.AppointmentDto;
import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.appointment.entity.IAppointmentRepository;
import com.springbootsauna.springbootsaunarestapi.user.entity.IUserRepository;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AppointmentService implements IAppointmentService{

    @Autowired
    private IAppointmentRepository iAppointmentRepository;
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public ResponseObject createAppointment(AppointmentDto appointmentDto) {
        try {
            Appointment appointment = new Appointment();
            BeanUtils.copyProperties(appointmentDto, appointment);
            appointment.setEAppointmentStatus(EAppointmentStatus.CUSTOMER_SUBMITTED);
            return new ResponseObject(iAppointmentRepository.save(appointment));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }

    @Override
    public ResponseObject processAppointment(ERole role, EAppointmentStatus appointmentStatus) {
        try {
            Appointment appointment = new Appointment();
            switch (role){
                case RECEPTIONIST :
                    if (appointmentStatus != EAppointmentStatus.CUSTOMER_SUBMITTED){
                        appointment.setEAppointmentStatus(EAppointmentStatus.RECEPTIONIST_APPROVED);
                    }else {
                        appointment.setEAppointmentStatus(EAppointmentStatus.RECEPTIONIST_REJECTED);
                    }
                    break;
                case MASSEUR:
                    if (appointmentStatus != EAppointmentStatus.RECEPTIONIST_APPROVED){
                        appointment.setEAppointmentStatus(EAppointmentStatus.MASSEUR_APPROVED);
                    }else {
                        appointment.setEAppointmentStatus(EAppointmentStatus.MASSEUR_REJECTED);
                    }
                    break;
                case MANAGER:
                    if (appointmentStatus != EAppointmentStatus.MASSEUR_APPROVED){
                        appointment.setEAppointmentStatus(EAppointmentStatus.MANAGER_APPROVED);
                    }else {
                        appointment.setEAppointmentStatus(EAppointmentStatus.MANAGER_REJECTED);
                    }
                    break;
                default:
                    throw new RuntimeException("role is not supported");
            }
            AppointmentDto appointmentDto = new AppointmentDto();
            BeanUtils.copyProperties(appointmentDto, appointment);
            return new ResponseObject(iAppointmentRepository.save(appointment));

        }catch (Exception exception){
            return new ResponseObject(exception);
        }

    }

    @Override
    public ResponseObject getAppointment(UUID id) {
        return null;
    }

    @Override
    public Page<Appointment> findAllAppointment(Integer pageNumber, Integer pageSize) {
        return null;
    }
}
