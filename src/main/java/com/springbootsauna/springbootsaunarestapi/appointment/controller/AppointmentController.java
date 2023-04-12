package com.springbootsauna.springbootsaunarestapi.appointment.controller;

import com.springbootsauna.springbootsaunarestapi.appointment.dto.AppointmentDto;
import com.springbootsauna.springbootsaunarestapi.appointment.service.IAppointmentService;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.EAppointmentStatus;
import com.springbootsauna.springbootsaunarestapi.util.ERole;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {
    @Autowired
    private IAppointmentService iAppointmentService;

    @PostMapping("create")
    public ResponseObject createAppointment(@RequestBody AppointmentDto  appointmentDto){
        try {
            return new ResponseObject(iAppointmentService.createAppointment(appointmentDto));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }
    @PostMapping("process")
    public ResponseObject processAppointment(@RequestParam ERole role, @RequestParam EAppointmentStatus appointmentStatus){
        try {
//            User user = new User();
            return new ResponseObject(iAppointmentService.processAppointment(role, appointmentStatus));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }
}
