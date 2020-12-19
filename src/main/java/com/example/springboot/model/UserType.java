package com.example.springboot.model;

public enum UserType {
    ADMIN("Admin",1),
    DOCTOR("Doctor",2),
    PATIENT("Patient",3);

    private String key;
    private Integer value;

    UserType(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public static UserType fromValue(Integer value) {
        UserType[] genders = values();
        for (UserType gender : genders) {
            if (gender.getValue().equals(value))
                return gender;
        }

        return null;
    }

    public static UserType fromKey(String key) {
        UserType[] genders = values();
        for (UserType gender : genders) {
            if (gender.getKey().equalsIgnoreCase(key))
                return gender;
        }

        return null;
    }

    public Integer getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
