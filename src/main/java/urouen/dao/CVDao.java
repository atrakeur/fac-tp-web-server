package urouen.dao;

import urouen.model.CV;
import urouen.model.CV_Experience;

import java.util.ArrayList;
import java.util.List;

public class CVDao {

    private String id;
    private String gender;
    private CVDao_Name name;
    private String firstName;

    private String objective;
    private List<CVDao_Experience> experiences;

    public CVDao(String id, String gender, CVDao_Name name, String firstName, String objective, List<CVDao_Experience> experiences) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.firstName = firstName;
        this.objective = objective;
        this.experiences = experiences;
    }

    public CVDao(CV cv) {
        this.id = cv.getId();
        this.gender = cv.getGender();
        this.name = new CVDao_Name(cv.getName());
        this.firstName = cv.getFirstname();
        this.objective = cv.getObjective();

        this.experiences = new ArrayList<>();
        for (CV_Experience exp: cv.getExperiences()) {
            this.experiences.add(new CVDao_Experience(exp));
        }
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
        List<CV_Experience> experiences = new ArrayList<>();
        for (CVDao_Experience exp: this.experiences) {
            experiences.add(exp.toCVExperience());
        }
        
        return new CV(
                this.id,
                this.gender,
                this.name.toCVName(),
                this.firstName,
                this.objective,
                experiences
        );
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
