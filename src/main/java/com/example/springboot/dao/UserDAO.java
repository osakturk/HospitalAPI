package com.example.springboot.dao;

import com.example.springboot.model.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserDAO {

    private static Users list = new Users();

    static {
        list.getUsers().add(new User(1, "ataylan", "password123", new Date(), UserType.DOCTOR));
        list.getUsers().add(new User(2, "akocadag", "password234", new Date(), UserType.PATIENT));
        list.getUsers().add(new User(3, "admin", "password", new Date(), UserType.ADMIN));

    }

    public Users getUsers() {

        return list;
    }

    public User addUser(User user) {
        user.setType(UserType.fromKey(user.getType().getKey()));
        list.getUsers().add(user);

        return user;
    }

    public User getPatientByUsername(String username){
        for (User user: list.getUsers()) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public User getPatientByUsernameAndPassword(String username, String password){
        for (User user: list.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public User getPatientById(long id){
        for (User user: list.getUsers()) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public boolean isAdmin(long id){
        for (User user: list.getUsers()) {
            if (user.getId() == id){
                if (user.getType().equals(UserType.ADMIN)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDoctor(long id){
        for (User user: list.getUsers()) {
            if (user.getId() == id){
                if (user.getType().equals(UserType.DOCTOR)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPatient(long id){
        for (User user: list.getUsers()) {
            if (user.getId() == id){
                if (user.getType().equals(UserType.PATIENT)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSelf(int parameterId,int realId){
        return parameterId != realId;
    }

    public void updateUser(User user) {
        for (User user1: list.getUsers()) {
            if (user1.getId() == user.getId()){
                list.getUsers().remove(user1);
                list.getUsers().add(user);
                break;
            }
        }
    }

    public void deleteUser(long id) {
        for (User user: list.getUsers()) {
            if (user.getId() == id){
                list.getUsers().remove(user);
                break;
            }
        }
    }
}
