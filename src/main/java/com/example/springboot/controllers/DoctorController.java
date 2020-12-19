package com.example.springboot.controllers;


import com.example.springboot.dao.DoctorDAO;
import com.example.springboot.model.Doctor;
import com.example.springboot.model.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoctorController {

    @Autowired
    DoctorDAO doctorDao;

    @GetMapping(path = "/api/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctors showAllDoctors() {
        return doctorDao.getDoctors();
    }

    @GetMapping(path = "/api/doctors/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor doctorViewByName(@PathVariable("name") String name) {
        return doctorDao.getDoctorByName(name);
    }

    @GetMapping(path = "/api/doctors/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor doctorViewById(@PathVariable("id") long id) {
        return doctorDao.getDoctorById(id);
    }

    @PostMapping(value = "/api/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor addDoctor(@RequestParam Map<String, String> formData) {
        Doctor doctor = Doctor.convertBody(formData);
        doctor.setId(doctorDao.getDoctors().getDoctors().size() + 1);
        return doctorDao.addDoctor(doctor);
    }

    @PutMapping(path = "/api/doctors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateDoctor(@PathVariable("id") long id, @RequestParam Map<String, String> formData) {
        Doctor doctor = Doctor.convertBody(formData);
        doctor.setId(id);
        doctorDao.updateDoctor(doctor);
    }

    @DeleteMapping(value = "/api/doctors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteDoctor(@PathVariable("id") long id) {
        doctorDao.deleteDoctor(id);
    }
}
