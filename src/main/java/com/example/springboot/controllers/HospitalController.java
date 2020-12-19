package com.example.springboot.controllers;

import com.example.springboot.dao.HospitalDAO;
import com.example.springboot.model.Hospitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HospitalController {

    @Autowired
    HospitalDAO hospitalDao;

    @GetMapping(path="/api/hospitals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hospitals getHospital(){
        return hospitalDao.getHospital();
    }

}
