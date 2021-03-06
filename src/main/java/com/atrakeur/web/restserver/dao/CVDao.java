package com.atrakeur.web.restserver.dao;

import com.atrakeur.web.restserver.model.*;

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
    private List<CVDao_Lang> langs = new ArrayList<>();
    private List<CVDao_ComputerSkill> computerSkills = new ArrayList<>();

    public CVDao(String id, String gender, CVDao_Name name, String firstName, String objective, List<CVDao_Experience> experiences, List<CVDao_School> schools, String skill, List<CVDao_Lang> langs, List<CVDao_ComputerSkill> computerSkills) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.firstName = firstName;
        this.objective = objective;
        this.experiences = experiences;
        this.schools = schools;
        this.skill = skill;
        this.langs = langs;
        this.computerSkills = computerSkills;
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

        this.langs = new ArrayList<>();
        for (CV_Lang lang: cv.getLangues()) {
            this.langs.add(new CVDao_Lang(lang));
        }

        this.computerSkills = new ArrayList<>();
        for (CV_ComputerSkill skill: cv.getComputerSkill()) {
            this.computerSkills.add(new CVDao_ComputerSkill(skill));
        }
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

        List<CV_Lang> langs = new ArrayList<>();
        for (CVDao_Lang lang: this.langs) {
            langs.add(lang.toCVLang());
        }

        List<CV_ComputerSkill> skills = new ArrayList<>();
        for (CVDao_ComputerSkill skill: this.computerSkills) {
            skills.add(skill.toCVComputerSkill());
        }

        return new CV(
                this.id,
                this.gender,
                this.name.toCVName(),
                this.firstName,
                this.objective,
                experiences,
                schools,
                this.skill,
                langs,
                skills
        );
    }
}
