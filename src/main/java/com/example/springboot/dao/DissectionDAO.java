package com.example.springboot.dao;

import com.example.springboot.model.Dissection;
import com.example.springboot.model.Dissections;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public class DissectionDAO {

    private static Dissections list = new Dissections();

    static {
        list.getDissections().add(new Dissection(UUID.randomUUID(), "BT", new Date()));
        list.getDissections().add(new Dissection(UUID.randomUUID(), "COVID TEST", new Date()));
        list.getDissections().add(new Dissection(UUID.randomUUID(), "Hemoglobin", new Date()));
        list.getDissections().add(new Dissection(UUID.randomUUID(), "Tit", new Date()));
    }

    public Dissections getDissections() {

        return list;
    }

    public Dissection addDissection(Dissection dissection) {
        list.getDissections().add(dissection);

        return dissection;
    }

    public void updateDissection(Dissection dissection) {
        for (Dissection dis : list.getDissections()) {
            if (dis.getId().equals(dissection.getId())) {
                list.getDissections().remove(dis);
                list.getDissections().add(dissection);
                break;
            }
        }
    }

    public void deleteDissection(UUID id) {
        for (Dissection dis : list.getDissections())
            if (dis.getId().equals(id)) {
                list.getDissections().remove(dis);
                break;
            }
    }


    public Dissection getDissectionByName(String name) {
        for (Dissection dissection : list.getDissections()) {
            if (dissection.getName().equals(name)) {
                return dissection;
            }
        }
        return null;
    }

    public Dissection getDissectionById(UUID id) {
        for (Dissection dissection : list.getDissections()) {
            if (dissection.getId().equals(id)) {
                return dissection;
            }
        }
        return null;
    }
}
