package com.example.springboot.model;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Patient {
    private long id;
    private String name;
    private String address;
    private String gender;
    private Disease disease;
    private Medicine medicine;
    private Dissection dissection;
    private String emailId;
    private String contactNumber;
    private Doctor doctor;

    public Patient() {
        super();
    }

    public Patient(long id, String name, String address, String gender, Disease disease, String emailId, String contactNumber, Doctor doctor, Medicine medicine, Dissection dissection) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.disease = disease;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.doctor = doctor;
        this.medicine = medicine;
        this.dissection = dissection;
    }

    public static Patient convertBody(Map<String, String> formData) {
        Patient patient = new Patient();

        patient.setName(formData.get("name/"));
        if (formData.get("address/") != null && !formData.get("address/").isEmpty()) {
            patient.setAddress(formData.get("address/"));
        }
        if (formData.get("gender/") != null && !formData.get("gender/").isEmpty()) {
            patient.setGender(formData.get("gender/"));
        }
        if (formData.get("disease/") != null && !formData.get("disease/").isEmpty()) {
            Disease disease = new Disease(UUID.randomUUID(), formData.get("disease/"));
            patient.setDisease(disease);
        }

        if (formData.get("medicine/") != null && !formData.get("medicine/").isEmpty()) {
            Medicine medicine = new Medicine(UUID.randomUUID(), formData.get("medicine/"));
            patient.setMedicine(medicine);
        }
        if (formData.get("dissection/") != null && !formData.get("dissection/").isEmpty()) {
            Dissection dissection = new Dissection(UUID.randomUUID(), formData.get("dissection/"), new Date());
            patient.setDissection(dissection);
        }
        if (formData.get("email/") != null && !formData.get("email/").isEmpty()) {
            patient.setEmailId(formData.get("email/"));
        }
        if (formData.get("contactNumber/") != null && !formData.get("contactNumber/").isEmpty()) {
            patient.setContactNumber(formData.get("contactNumber/"));
        }
        if (formData.get("doctor/") != null && !formData.get("doctor/").isEmpty()) {
            Doctor doctor = new Doctor();
            doctor.setName(formData.get("doctor/"));
            patient.setDoctor(doctor);
        }

        return patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Dissection getDissection() {
        return dissection;
    }

    public void setDissection(Dissection dissection) {
        this.dissection = dissection;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", disease=" + disease +
                ", medicine=" + medicine +
                ", dissection=" + dissection +
                ", emailId='" + emailId + '\'' +
                ", contactNumber=" + contactNumber +
                ", doctor=" + doctor +
                '}';
    }
}
