package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Diseases {
    private List<Disease> diseases;

    public List<Disease> getDiseases() {
        if(diseases == null) {
            diseases = new ArrayList<>();
        }
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}
