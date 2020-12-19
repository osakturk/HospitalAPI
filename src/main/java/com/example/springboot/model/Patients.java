package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Patients {

    private List<Patient> patients;

    public List<Patient> getPatients() {
        if(patients == null) {
            patients = new ArrayList<>();
        }
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
