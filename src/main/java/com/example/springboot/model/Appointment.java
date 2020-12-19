package com.example.springboot.model;

import com.example.springboot.util.Util;
import org.json.JSONObject;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Appointment {
    private long id;
    private Patient patient;
    private Doctor doctor;
    private Hospital hospital;
    private Date date;

    public Appointment() {
    }

    public Appointment(long id, Patient patient, Doctor doctor, Hospital hospital, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.hospital = hospital;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public static Appointment convertBody(Map<String, String> formData) {
        Appointment appointment = new Appointment();
        if (formData.get("patient/") != null && !formData.get("patient/").isEmpty()) {
            Patient patient = new Patient();
            patient.setName(formData.get("patient/"));
            appointment.setPatient(patient);
        }
        if (formData.get("hospital/") != null && !formData.get("hospital/").isEmpty()) {
            Hospital hospital = new Hospital();
            hospital.setName(formData.get("hospital/"));
            appointment.setHospital(hospital);
        }

        if (formData.get("doctor/") != null && !formData.get("doctor/").isEmpty()) {
            Doctor doctor = new Doctor();
            doctor.setName(formData.get("doctor/"));
            appointment.setDoctor(doctor);
        }

        if (formData.get("date/") != null && !formData.get("date/").isEmpty()) {
            appointment.setDate(new Date(Util.milliSecondsToDate(formData.get("date/"))));
        }

        return appointment;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
