package com.example.springboot.controllers;

import com.example.springboot.dao.UserDAO;
import com.example.springboot.model.User;
import com.example.springboot.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserDAO userDao;

    @GetMapping(path="/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Users show(){
        return userDao.getUsers();
    }

    @PostMapping(value="/api/users", produces= MediaType.APPLICATION_JSON_VALUE)
    public User add(@RequestParam Map<String, String> formData) {
        User user = User.convertBody(formData);
        user.setId(userDao.getUsers().getUsers().size() + 1);
        return userDao.addUser(user);
    }

    @GetMapping(path="/api/users/name/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User userViewByName(@PathVariable("username") String name ) {
        return userDao.getPatientByUsername(name);
    }

    @GetMapping(path="/api/users/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User userViewById(HttpServletResponse response, @PathVariable("id") long id) {
        return userDao.getPatientById(id);
    }

    @PutMapping(value="/api/users/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value= HttpStatus.OK)
    public void updateUser(@PathVariable("id") long id, @RequestParam Map<String, String> formData) {
        User user = User.convertBody(formData);
        user.setId(id);
        userDao.updateUser(user);
    }

    @DeleteMapping(value="/api/users/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void deleteUser(@PathVariable("id") long id) {
        userDao.deleteUser(id);
    }
}
