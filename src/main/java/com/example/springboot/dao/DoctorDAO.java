package com.example.springboot.dao;

import com.example.springboot.model.Doctor;
import com.example.springboot.model.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDAO {

    @Autowired
    HospitalDAO hospitalDao;

    private static Doctors list = new Doctors();

    static {
        list.getDoctors().add(new Doctor(123, "Ahmet Mümtaz Taylan", "Doç.Dr.", "", 12, "İstanbul", "ataylan@mail.com", "123"));
        list.getDoctors().add(new Doctor(234, "Recep Akdağ", "Uzm.Dr.", "", 12, "Ankara", "rakdag@mail.com", "234"));
        list.getDoctors().add(new Doctor(345, "Adnan Kakilli", "Prof.Dr.", "", 12, "İstanbul", "akakilli@mail.com", "345"));
    }

    public Doctors getDoctors() {

        return list;
    }

    public Doctor addDoctor(Doctor doctor) {
//        doctor.setHospital(hospitalDao.getHospitalById(doctor.getHospital().getId()));
        list.getDoctors().add(doctor);
        return doctor;
    }

    public void updateDoctor(Doctor doctor) {
        for (Doctor doc : list.getDoctors()) {
            if (doc.getId() == doctor.getId()) {
                list.getDoctors().remove(doc);
                doctor.setHospital(hospitalDao.getHospitalById(doctor.getHospital().getId()));
                list.getDoctors().add(doctor);
                break;
            }
        }
    }

    public void deleteDoctor(long id) {
        for (Doctor doc : list.getDoctors()) {
            if (doc.getId() == id) {
                list.getDoctors().remove(doc);
                break;
            }
        }
    }

    public Doctor getDoctorByName(String name) {
        for (Doctor doctor : list.getDoctors()) {
            if (doctor.getName().equals(name)) {
                return doctor;
            }
        }
        return null;
    }

    public Doctor getDoctorById(long id) {
        for (Doctor doctor : list.getDoctors()) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public boolean isDoctor(long id) {
        for (Doctor doctor : list.getDoctors()) {
            if (doctor.getId() == id) {
                return true;

            }
        }
        return false;
    }
}
