package urouen.dao;

import urouen.model.CV;
import urouen.model.CV_Experience;
import urouen.model.CV_School;

import java.util.ArrayList;
import java.util.List;

public class CVDao {

    private String id;
    private String gender;
    private CVDao_Name name;
    private String firstName;

    private String objective;
    private List<CVDao_Experience> experiences = new ArrayList<>();
    private List<CVDao_School> schools = new ArrayList<>();
    private String skill;

    public CVDao(String id, String gender, CVDao_Name name, String firstName, String objective, List<CVDao_Experience> experiences, List<CVDao_School> schools, String skill) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.firstName = firstName;
        this.objective = objective;
        this.experiences = experiences;
        this.schools = schools;
        this.skill = skill;
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

        this.schools = new ArrayList<>();
        for (CV_School school: cv.getSchools()) {
            this.schools.add(new CVDao_School(school));
        }
        this.skill = cv.getSkill();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CV toCV() {
        List<CV_Experience> experiences = new ArrayList<>();
        for (CVDao_Experience exp: this.experiences) {
            experiences.add(exp.toCVExperience());
        }

        List<CV_School> schools = new ArrayList<>();
        for (CVDao_School school: this.schools) {
            schools.add(school.toCVSchool());
        }

        return new CV(
                this.id,
                this.gender,
                this.name.toCVName(),
                this.firstName,
                this.objective,
                experiences,
                schools,
                this.skill
        );
    }
}
