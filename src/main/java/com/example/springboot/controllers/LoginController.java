package com.example.springboot.controllers;

import com.example.springboot.dao.UserDAO;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    UserDAO userDAO;

    @PostMapping(path = "/api/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestParam Map<String, String> formData) {
        User user = User.convertBodyForLogin(formData);
        return userDAO.getPatientByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
