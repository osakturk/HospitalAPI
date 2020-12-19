package com.example.springboot.dao;

import com.example.springboot.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public class AppointmentDao {

    @Autowired
    PatientDAO patientDao;

    @Autowired
    DoctorDAO doctorDao;

    @Autowired
    HospitalDAO hospitalDao;

    private static Appointments list = new Appointments();

    static {
        list.getAppointments().add(new Appointment(1, new Patient(1, "Ali Kocadağ", "İstanbul", "Erkek", new Disease(UUID.randomUUID(), "Akut Gastro Entrit"), "akocadag@mail.com", "1111111111", new Doctor(123, "Ahmet Mümtaz Taylan", "Doç.Dr.", "", 12, "İstanbul", "ataylan@mail.com", "123"), null, null),
                new Doctor(123, "Ahmet Mümtaz Taylan", "Doç.Dr.", "", 12, "İstanbul", "ataylan@mail.com", "123"),
                new Hospital("Florence Nigthngale", "İstanbul", "Gupta", "1111110011"), new Date()));
        list.getAppointments().add(new Appointment(1, new Patient(1, "Ali Kocadağ", "İstanbul", "Erkek", new Disease(UUID.randomUUID(), "Akut Gastro Entrit"), "akocadag@mail.com", "1111111111", new Doctor(123, "Ahmet Mümtaz Taylan", "Doç.Dr.", "", 12, "İstanbul", "ataylan@mail.com", "123"), null, null),
                new Doctor(234, "Recep Akdağ", "Uzm.Dr.", "",12,"Ankara","rakdag@mail.com","234"),
                new Hospital("Acıbadem", "Ankara", "www.acibadem.com", "1111110011"), new Date()));
        list.getAppointments().add(new Appointment(1, new Patient(1, "Ali Kocadağ", "İstanbul", "Erkek", new Disease(UUID.randomUUID(), "Akut Gastro Entrit"), "akocadag@mail.com", "1111111111", new Doctor(123, "Ahmet Mümtaz Taylan", "Doç.Dr.", "", 12, "İstanbul", "ataylan@mail.com", "123"), null, null),
                new Doctor(345, "Adnan Kakilli", "Prof.Dr.", "",12,"İstanbul","akakilli@mail.com","345"),
                new Hospital("Cerrahpaşa", "İstanbul", "www.cerrahpasa.com", "1111110011"), new Date()));
    }

    public Appointments getAppointments() {

        return list;
    }

    public Appointment addAppointment(Appointment appointment) {
        appointment.setDoctor(doctorDao.getDoctorById(appointment.getDoctor().getId()));
        appointment.setHospital(hospitalDao.getHospitalById(appointment.getHospital().getId()));
        appointment.setPatient(patientDao.getPatientById(appointment.getPatient().getId()));
        list.getAppointments().add(appointment);

        return appointment;
    }

    public void updateAppointment(Appointment appointment) {
        for (Appointment appointment1 : list.getAppointments()) {
            if (appointment1.getId() == appointment.getId()) {
                list.getAppointments().remove(appointment1);
                appointment.setDoctor(doctorDao.getDoctorById(appointment.getDoctor().getId()));
                appointment.setHospital(hospitalDao.getHospitalById(appointment.getHospital().getId()));
                appointment.setPatient(patientDao.getPatientById(appointment.getPatient().getId()));
                list.getAppointments().add(appointment);
                break;
            }
        }
    }

    public void deleteAppointment(long id) {
        for (Appointment appointment1 : list.getAppointments()) {
            if (appointment1.getId() == id) {
                list.getAppointments().remove(appointment1);
                break;
            }
        }
    }

    public Appointments getAppointmentsByDate(Date date) {
        Appointments appointments = new Appointments();
        for (Appointment appointment : list.getAppointments()) {
            if (appointment.getDate().equals(date)) {
                appointments.getAppointments().add(appointment);
            }
        }
        return appointments;
    }

    public Appointment getAppointmentById(long id) {
        for (Appointment appointment : list.getAppointments()) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }
}
