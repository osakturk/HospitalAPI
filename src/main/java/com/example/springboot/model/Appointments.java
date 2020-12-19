package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Appointments {

    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        if(appointments == null) {
            appointments = new ArrayList<>();
        }
        return appointments;
    }

    public void setAppointments(List<Appointment> Appointments) {
        this.appointments = Appointments;
    }
}
