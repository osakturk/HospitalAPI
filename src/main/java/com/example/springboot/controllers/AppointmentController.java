package com.example.springboot.controllers;

import com.example.springboot.dao.AppointmentDao;
import com.example.springboot.model.Appointment;
import com.example.springboot.model.Appointments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppointmentController {
    @Autowired
    AppointmentDao appointmentDao;

    @GetMapping(path="/api/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Appointments showAllAppointments(){
        return appointmentDao.getAppointments();
    }

    @GetMapping(path="/api/appointments/name/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Appointments appointmentViewByDate(@PathVariable("date") Date date ) {
        return appointmentDao.getAppointmentsByDate(date);
    }

    @GetMapping(path="/api/appointments/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Appointment appointmentViewById(@PathVariable("id") long id) {
        return appointmentDao.getAppointmentById(id);
    }

    @PostMapping(value="/api/appointments", produces= MediaType.APPLICATION_JSON_VALUE)
    public Appointment addAppointment(@RequestParam Map<String, String> formData) {
        Appointment appointment = Appointment.convertBody(formData);
        appointment.setId(appointmentDao.getAppointments().getAppointments().size() + 1);
        return appointmentDao.addAppointment(appointment);
    }

    @PutMapping(value="/api/appointments/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void updateAppointment(@PathVariable("id") long id, @RequestParam Map<String, String> formData) {
        Appointment appointment = Appointment.convertBody(formData);
        appointment.setId(id);
        appointmentDao.updateAppointment(appointment);
    }

    @DeleteMapping(value="/api/appointments/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void deleteAppointment(@PathVariable("id") long id) {
        appointmentDao.deleteAppointment(id);
    }
}
