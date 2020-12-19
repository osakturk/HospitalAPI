package com.example.springboot.dao;

import com.example.springboot.model.Disease;
import com.example.springboot.model.Doctor;
import com.example.springboot.model.Patient;
import com.example.springboot.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PatientDAO {

    @Autowired
    DissectionDAO dissectionDao;

    @Autowired
    DiseaseDAO diseaseDao;

    @Autowired
    MedicineDAO medicineDAO;

    private static Patients list = new Patients();

    static
    {
        list.getPatients().add(new Patient(1,"Ali Kocadağ","İstanbul","Erkek",new Disease(UUID.randomUUID(),"Akut Gastro Entrit"),"akocadag@mail.com","1111111111",new Doctor(123, "Ahmet Mümtaz Taylan", "Doç.Dr.", "",12,"İstanbul","ataylan@mail.com","123"),null,null));
        list.getPatients().add(new Patient(2,"Ahmet Necdet Ersoy","İstanbul","Erkek",new Disease(UUID.randomUUID(),"Diabetüs İnsipidus"),"anersoy@mail.com","1111111111",new Doctor(345, "Adnan Kakilli", "Prof.Dr.", "",12,"İstanbul","akakilli@mail.com","345"),null,null));
        list.getPatients().add(new Patient(3,"Emre Aytepe","İstanbul","Erkek",new Disease(UUID.randomUUID(),"COVID-19"),"eaytepe@mail.com","1111111111",new Doctor(345, "Adnan Kakilli", "Prof.Dr.", "",12,"İstanbul","akakilli@mail.com","345"),null,null));
        list.getPatients().add(new Patient(4,"Ömer Aktürk","İstanbul","Erkek",new Disease(UUID.randomUUID(),"Diabetüs Mellitus"),"oakturk@mail.com","1111111111",new Doctor(123, "Ahmet Mümtaz Taylan", "Doç.Dr.", "",12,"İstanbul","ataylan@mail.com","123"),null,null));
        list.getPatients().add(new Patient(5,"Pınar Alptekin","Ankara","Kadın",new Disease(UUID.randomUUID(),"KOAH"),"palptekin@mail.com","1111111111",new Doctor(234, "Recep Akdağ", "Uzm.Dr.", "",12,"Ankara","rakdag@mail.com","234"),null,null));

    }
    public Patients getPatients() {

        return list;
    }

    public Patient addPatients(Patient patient) {
        patient.setDisease(diseaseDao.getDiseaseById(patient.getDisease().getId()));
        patient.setDissection(dissectionDao.getDissectionById(patient.getDissection().getId()));
        patient.setMedicine(medicineDAO.getMedicineById(patient.getMedicine().getId()));
        list.getPatients().add(patient);

        return patient;
    }

    public void updatePatient(Patient patient) {
        for (Patient pat: list.getPatients()) {
            if (pat.getId() == patient.getId()){
                list.getPatients().remove(pat);
                patient.setDisease(diseaseDao.getDiseaseById(patient.getDisease().getId()));
                patient.setDissection(dissectionDao.getDissectionById(patient.getDissection().getId()));
                patient.setMedicine(medicineDAO.getMedicineById(patient.getMedicine().getId()));
                list.getPatients().add(patient);
                break;
            }
        }
    }

    public void deletePatient(long id) {
        for (Patient patient: list.getPatients()) {
            if (patient.getId() == id){
                list.getPatients().remove(patient);
                break;
            }
        }
    }

    public Patient getPatientByName(String name){
        for (Patient patient: list.getPatients()) {
            if (patient.getName().equals(name)){
                return patient;
            }
        }
        return null;
    }

    public Patient getPatientById(long id){
        for (Patient patient: list.getPatients()) {
            if (patient.getId() == id){
                return patient;
            }
        }
        return null;
    }
}
