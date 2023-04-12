package com.springbootsauna.springbootsaunarestapi.appointment.controller;

import com.springbootsauna.springbootsaunarestapi.appointment.dto.AppointmentDto;
import com.springbootsauna.springbootsaunarestapi.appointment.service.IAppointmentService;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
