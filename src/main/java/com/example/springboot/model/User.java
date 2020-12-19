package com.example.springboot.model;

import org.json.JSONObject;

import java.util.Date;
import java.util.Map;

public class User {

    private long id;
    private String username;
    private String password;
    private Date createDate;
    private UserType type;

    public User() {
    }

    public User(long id, String username, String password, Date createDate, UserType type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.type = type;
    }

    public static User convertBody(Map<String, String> formData) {
        User user = new User();
        user.setType(UserType.fromKey(formData.get("type/")));
        user.setPassword(formData.get("password/"));
        user.setUsername(formData.get("username/"));
        return user;
    }

    public static User convertBodyForLogin(Map<String, String> formData) {
        User user = new User();
        user.setPassword(formData.get("password"));
        user.setUsername(formData.get("username"));
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
