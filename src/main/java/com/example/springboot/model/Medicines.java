package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Medicines {
    private List<Medicine> medicines;

    public List<Medicine> getMedicines() {
        if(medicines == null) {
            medicines = new ArrayList<>();
        }
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
