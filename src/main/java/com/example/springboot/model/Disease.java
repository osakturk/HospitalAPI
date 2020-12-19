package com.example.springboot.model;

import com.example.springboot.exception.CustomExceptionHandler;
import org.json.JSONObject;

import java.util.Map;
import java.util.UUID;

public class Disease {
    private UUID id;
    private String name;


    public Disease() {
    }

    public Disease(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Disease convertBody(Map<String, String> formData){
        Disease disease = new Disease();

        if (formData.get("id/") != null && !formData.get("id/").isEmpty()){
            disease.setId(UUID.fromString(formData.get("id/")));
        }

        if (formData.get("name/") != null && !formData.get("name/").isEmpty()){
            disease.setName(formData.get("name/"));
        } else {
            new CustomExceptionHandler().handlerParameterException(new Exception("Missing name parameter"),null);
        }

        return disease;
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
