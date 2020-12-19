package com.example.springboot.model;

public class Hospital {
    private long id;
    private String name;
    private String address;
    private String website;
    private String contactNumber;

    public Hospital() {
        super();
    }

    public Hospital(String name, String address, String website, String contactNumber) {
        super();
        this.name = name;
        this.address = address;
        this.website = website;
        this.contactNumber = contactNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Hospital [id=" + id + ", name=" + name + ", address=" + address + ", website=" + website
                + ", contactNumber=" + contactNumber + "]";
    }
}
