package urouen.dao;

import urouen.model.CV;

import java.io.Serializable;

public class CVDao {

    private String id;
    private String name;
    private String firstName;

    public CVDao(String id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
    }

    public CVDao(CV cv) {
        this.id = cv.getId();
        this.name = cv.getName();
        this.firstName = cv.getFirstname();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CV toCV() {
        return new CV(this.id, this.name, this.firstName);
    }
}