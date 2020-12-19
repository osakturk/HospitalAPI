package com.example.springboot.dao;

import com.example.springboot.model.Medicine;
import com.example.springboot.model.Medicines;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MedicineDAO {
    private static Medicines list = new Medicines();

    static {
        list.getMedicines().add(new Medicine(UUID.randomUUID(), "Apranax"));
        list.getMedicines().add(new Medicine(UUID.randomUUID(), "Majezik"));
        list.getMedicines().add(new Medicine(UUID.randomUUID(), "Nurofen"));
        list.getMedicines().add(new Medicine(UUID.randomUUID(), "Parol"));
        list.getMedicines().add(new Medicine(UUID.randomUUID(), "Calpol"));
    }

    public Medicines getMedicines() {

        return list;
    }

    public Medicine addMedicine(Medicine medicine) {
        list.getMedicines().add(medicine);

        return medicine;
    }

    public void updateMedicine(Medicine Medicine) {
        for (Medicine med : list.getMedicines()) {
            if (med.getId().equals(Medicine.getId())) {
                list.getMedicines().remove(med);
                list.getMedicines().add(Medicine);
                break;
            }
        }
    }

    public void deleteMedicine(UUID id) {
        for (Medicine medicine : list.getMedicines()) {
            if (medicine.getId().equals(id)) {
                list.getMedicines().remove(medicine);
                break;
            }
        }
    }

    public Medicine getMedicineByName(String name) {
        for (Medicine medicine : list.getMedicines()) {
            if (medicine.getName().equals(name)) {
                return medicine;
            }
        }
        return null;
    }

    public Medicine getMedicineById(UUID id) {
        for (Medicine medicine : list.getMedicines()) {
            if (medicine.getId().equals(id)) {
                return medicine;
            }
        }
        return null;
    }
}
