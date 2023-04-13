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
    public ResponseObject processAppointment(UUID user_id, UUID appointment_id, EAppointmentStatus appointmentStatus) {
        try {
            User user = iUserRepository.findById(user_id).get();
            ERole role = user.getRole();
            Appointment appointment = iAppointmentRepository.findById(appointment_id).get();
            switch (role){
                case RECEPTIONIST :
                    if ((appointment.getEAppointmentStatus() == EAppointmentStatus.CUSTOMER_SUBMITTED || appointment.getEAppointmentStatus() == EAppointmentStatus.RECEPTIONIST_REJECTED) && ((appointmentStatus == EAppointmentStatus.RECEPTIONIST_APPROVED) || (appointmentStatus == EAppointmentStatus.RECEPTIONIST_REJECTED))){
                        appointment.setEAppointmentStatus(appointmentStatus);
                    }
                    break;
                case MASSEUR:
                    if (((appointment.getEAppointmentStatus() == EAppointmentStatus.RECEPTIONIST_APPROVED) && ((appointmentStatus == EAppointmentStatus.MASSEUR_APPROVED) || (appointmentStatus == EAppointmentStatus.MASSEUR_REJECTED)))){
                        appointment.setEAppointmentStatus(appointmentStatus);
                    }
                    break;
                case MANAGER:
                    if ((appointment.getEAppointmentStatus() == EAppointmentStatus.MASSEUR_APPROVED) && ((appointmentStatus == EAppointmentStatus.MANAGER_APPROVED) || (appointmentStatus == EAppointmentStatus.MANAGER_REJECTED))){
                        appointment.setEAppointmentStatus(appointmentStatus);
                    }
                    break;
                default:
                    throw new RuntimeException("role is not supported");
            }
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
