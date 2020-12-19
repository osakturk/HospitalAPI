package com.example.springboot.dao;

import com.example.springboot.model.Disease;
import com.example.springboot.model.Diseases;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class DiseaseDAO {
    private static Diseases list = new Diseases();

    static {
        list.getDiseases().add(new Disease(UUID.randomUUID(), "Akut Gastro Entrit"));
        list.getDiseases().add(new Disease(UUID.randomUUID(), "Diabetüs İnsipidus"));
        list.getDiseases().add(new Disease(UUID.randomUUID(), "COVID-19"));
        list.getDiseases().add(new Disease(UUID.randomUUID(), "Diabetüs Mellitus"));
        list.getDiseases().add(new Disease(UUID.randomUUID(), "KOAH"));
    }

    public Diseases getDiseases() {

        return list;
    }

    public Disease addDisease(Disease Disease) {
        list.getDiseases().add(Disease);

        return Disease;
    }

    public void updateDisease(Disease disease) {
        for (Disease dis : list.getDiseases()) {
            if (dis.getId().equals(disease.getId())) {
                list.getDiseases().remove(dis);
                list.getDiseases().add(disease);
                break;
            }
        }
    }

    public void deleteDisease(UUID id) {
        for (Disease dis : list.getDiseases()) {
            if (dis.getId().equals(id)) {
                list.getDiseases().remove(dis);
                break;
            }
        }
    }

    public Disease getDiseaseByName(String name) {
        for (Disease disease : list.getDiseases()) {
            if (disease.getName().equals(name)) {
                return disease;
            }
        }
        return null;
    }

    public Disease getDiseaseById(UUID id) {
        for (Disease disease : list.getDiseases()) {
            if (disease.getId().equals(id)) {
                return disease;
            }
        }
        return null;
    }
}
