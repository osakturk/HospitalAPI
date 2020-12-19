package com.example.springboot.model;

import com.example.springboot.exception.CustomExceptionHandler;
import org.json.JSONObject;

import java.util.Map;
import java.util.UUID;

public class Medicine {
    private UUID id;
    private String name;

    public Medicine() {
    }

    public Medicine(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Medicine convertBody(Map<String, String> formData){
        Medicine medicine = new Medicine();

        if (formData.get("id/") != null && !formData.get("id/").isEmpty()){
            medicine.setId(UUID.fromString(formData.get("id/")));
        }
        if (formData.get("name/") != null && !formData.get("name/").isEmpty()){
            medicine.setName(formData.get("name/"));
        } else {
            new CustomExceptionHandler().handlerParameterException(new Exception("Missing name parameter"),null);
        }


        return medicine;
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
}
