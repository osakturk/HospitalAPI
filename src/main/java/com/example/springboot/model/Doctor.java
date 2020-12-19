package com.example.springboot.model;

import com.example.springboot.exception.CustomExceptionHandler;
import org.json.JSONObject;
import org.springframework.util.MultiValueMap;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Doctor {
    private long id;
    private String name;
    private String designation;
    private String degree;
    private int experience;
    private String address;
    private String emailId;
    private String contactNumber;
    private Hospital hospital;

    public Doctor() {
    }

    public Doctor(long id, String name, String designation, String degree, int experience, String address, String emailId, String contactNumber) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.degree = degree;
        this.experience = experience;
        this.address = address;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
    }

    public static Doctor convertBody (Map<String,String> requestBody){
        Doctor doctor = new Doctor();
        if (requestBody.get("id/") != null){
            if (!requestBody.get("id/").isEmpty()){
                doctor.setId(Long.parseLong(requestBody.get("id/")));
            }
        }
        if (requestBody.get("name/") != null && !requestBody.get("name/").isEmpty()){
            doctor.setName(requestBody.get("name/"));
        } else {
            new CustomExceptionHandler().handlerParameterException(new Exception("Missing name parameter"),null);
        }
        if (requestBody.get("designation/") != null && !requestBody.get("designation/").isEmpty()){
            doctor.setDesignation(requestBody.get("designation/"));
        }

        if (requestBody.get("degree/") != null &&!requestBody.get("degree/").isEmpty()){
            doctor.setDegree(requestBody.get("degree/"));
        } else {
            new CustomExceptionHandler().handlerParameterException(new Exception("Missing degree parameter"),null);
        }
        if (requestBody.get("experience/") != null && !requestBody.get("experience/").isEmpty()){
            doctor.setExperience(Integer.parseInt(requestBody.get("experience/")));
        }
        if (requestBody.get("address/") != null && !requestBody.get("address/").isEmpty()){
            doctor.setAddress(requestBody.get("address/"));
        }
        if (requestBody.get("contactNumber/") != null && !requestBody.get("contactNumber/").isEmpty()){
            doctor.setContactNumber(requestBody.get("contactNumber/"));
        }

        return doctor;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", degree='" + degree + '\'' +
                ", experience=" + experience +
                ", address='" + address + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNumber=" + contactNumber +
                ", hospital=" + hospital +
                '}';
    }
}
