package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Doctors {

    private List<Doctor> doctors;

    public List<Doctor> getDoctors() {
        if(doctors == null) {
            doctors = new ArrayList<>();
        }
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
