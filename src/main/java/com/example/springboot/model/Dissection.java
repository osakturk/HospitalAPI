package com.example.springboot.model;

import com.example.springboot.exception.CustomExceptionHandler;
import com.example.springboot.util.Util;
import org.json.JSONObject;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Dissection {
    private UUID id;
    private String name;
    private Date date;

    public Dissection() {
    }

    public Dissection(UUID id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public static Dissection convertBody(Map<String, String> formData){
        Dissection dissection = new Dissection();


        if (formData.get("name/") != null && !formData.get("name/").isEmpty()){
            dissection.setName(formData.get("name/"));
        } else {
            new CustomExceptionHandler().handlerParameterException(new Exception("Missing name parameter"),null);
        }

        if (formData.get("id/") != null && !formData.get("id/").isEmpty()){
            dissection.setId(UUID.fromString(formData.get("id/")));
        }

        if (formData.get("date/") != null && !formData.get("date/").isEmpty()){
            dissection.setDate(new Date(Util.milliSecondsToDate(formData.get("date/"))));
        }

        return dissection;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
