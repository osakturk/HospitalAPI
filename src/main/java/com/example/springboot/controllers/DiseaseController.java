package com.example.springboot.controllers;

import com.example.springboot.dao.DiseaseDAO;
import com.example.springboot.model.Disease;
import com.example.springboot.model.Diseases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiseaseController {
    @Autowired
    DiseaseDAO diseaseDao;

    @GetMapping(path="/api/diseases", produces = MediaType.APPLICATION_JSON_VALUE)
    public Diseases showAllDiseases(){
        return diseaseDao.getDiseases();
    }

    @GetMapping(path="/api/diseases/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disease diseaseViewByName(@PathVariable("name") String name ) {
        return diseaseDao.getDiseaseByName(name);
    }

    @GetMapping(path="/api/diseases/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disease diseaseViewById(@PathVariable("id") String id) {
        return diseaseDao.getDiseaseById(UUID.fromString(id));
    }

    @PostMapping(value="/api/diseases", produces= MediaType.APPLICATION_JSON_VALUE)
    public Disease addDisease(@RequestParam Map<String, String> formData) {
        Disease disease = Disease.convertBody(formData);
        disease.setId(UUID.randomUUID());
        return diseaseDao.addDisease(disease);
    }

    @PutMapping(value="/api/diseases/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void updateDisease(@PathVariable("id") String id, @RequestParam Map<String, String> formData) {
        Disease disease = Disease.convertBody(formData);
        disease.setId(UUID.fromString(id));
        diseaseDao.updateDisease(disease);
    }

    @DeleteMapping(value="/api/diseases/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void deleteDisease(@PathVariable("id") String id) {
        diseaseDao.deleteDisease(UUID.fromString(id));
    }
}
