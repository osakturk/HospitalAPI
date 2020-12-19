package com.example.springboot.controllers;

import com.example.springboot.dao.DissectionDAO;
import com.example.springboot.model.Dissection;
import com.example.springboot.model.Dissections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DissectionController {

    @Autowired
    DissectionDAO dissectionDao;

    @GetMapping(path = "/api/dissections", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dissections showAllDissections() {
        return dissectionDao.getDissections();
    }

    @GetMapping(path = "/api/dissections/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dissection dissectionViewByName(@PathVariable("name") String name) {
        return dissectionDao.getDissectionByName(name);
    }

    @GetMapping(path = "/api/dissections/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dissection dissectionViewById(@PathVariable("id") String id) {
        return dissectionDao.getDissectionById(UUID.fromString(id));
    }

    @PostMapping(value = "/api/dissections", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dissection addDissection(@RequestParam Map<String, String> formData) {
        Dissection dissection = Dissection.convertBody(formData);
        dissection.setId(UUID.randomUUID());
        return dissectionDao.addDissection(dissection);
    }

    @PutMapping(value = "/api/dissections/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateDissection(@PathVariable("id") String id, @RequestParam Map<String, String> formData) {
        Dissection dissection = Dissection.convertBody(formData);
        dissection.setId(UUID.fromString(id));
        dissectionDao.updateDissection(dissection);
    }

    @DeleteMapping(value = "/api/dissections/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteDissection(@PathVariable("id") String id) {
        dissectionDao.deleteDissection(UUID.fromString(id));
    }
}
