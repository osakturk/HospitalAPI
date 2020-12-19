package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Dissections {

    private List<Dissection> dissections;

    public List<Dissection> getDissections() {
        if(dissections == null) {
            dissections = new ArrayList<>();
        }
        return dissections;
    }

    public void setDissections(List<Dissection> dissections) {
        this.dissections = dissections;
    }

}
