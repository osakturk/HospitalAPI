package com.example.springboot.controllers;


import com.example.springboot.dao.PatientDAO;
import com.example.springboot.model.Patient;
import com.example.springboot.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {

    @Autowired
    PatientDAO patientDao;

    @GetMapping(path="/api/patients", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patients showAllPatients(HttpServletResponse response){

        return patientDao.getPatients();
    }

    @GetMapping(path="/api/patients/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient patientViewByName(@PathVariable("name") String name ) {
        return patientDao.getPatientByName(name);
    }

    @GetMapping(path="/api/patients/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient patientViewById(@PathVariable("id") long id) {
        return patientDao.getPatientById(id);
    }

    @PostMapping(value="/api/patients", produces= MediaType.APPLICATION_JSON_VALUE)
    public Patient addPatient(@RequestParam Map<String, String> formData) {
        Patient patient = Patient.convertBody(formData);
        patient.setId(patientDao.getPatients().getPatients().size() + 1);
        return patientDao.addPatients(patient);
    }

    @PutMapping(value="/api/patients/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void updatePatient(@PathVariable("id") long id, @RequestParam Map<String, String> formData) {
        Patient patient = Patient.convertBody(formData);
        patient.setId(id);
        patientDao.updatePatient(patient);
    }

    @DeleteMapping(value="/api/patients/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void deletePatient(@PathVariable("id") long id) {
        patientDao.deletePatient(id);
    }
}
