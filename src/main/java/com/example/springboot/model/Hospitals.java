package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Hospitals {

    private List<Hospital> hospitalList;

    public List<Hospital> getHospitalList() {
        if (hospitalList == null) {
            hospitalList = new ArrayList<>();
        }
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }
}
