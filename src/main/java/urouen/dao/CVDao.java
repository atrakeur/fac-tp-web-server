package urouen.dao;

import urouen.model.CV;

public class CVDao {

    private String id;
    private CVDao_Name name;
    private String firstName;

    public CVDao(String id, CVDao_Name name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
    }

    public CVDao(CV cv) {
        this.id = cv.getId();
        this.name = new CVDao_Name(cv.getName());
        this.firstName = cv.getFirstname();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CVDao_Name getName() {
        return name;
    }

    public void setName(CVDao_Name name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CV toCV() {
        return new CV(this.id, this.name.toCVName(), this.firstName);
    }

}
