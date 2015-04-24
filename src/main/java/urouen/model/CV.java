package urouen.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "cv")
public class CV {

    private String id;
    private String gender;
    private CV_Name name;
    private String firstname;

    private String objective;
    private List<CV_Experience> experiences = new ArrayList<>();
    private List<CV_School> schools = new ArrayList<>();

    public CV() {
        super();
    }

    public CV(String id, String gender, CV_Name name, String firstname, String objective, List<CV_Experience> experiences, List<CV_School> schools) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.firstname = firstname;
        this.objective = objective;
        this.experiences = experiences;
        this.schools = schools;
    }

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    @XmlElement
    public void setFirstname(String firtname) {
        this.firstname = firtname;
    }

    public CV_Name getName() {
        return name;
    }

    @XmlElement
    public void setName(CV_Name name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    @XmlElement
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getObjective() {
        return objective;
    }

    @XmlElement
    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<CV_Experience> getExperiences() {
        return experiences;
    }

    @XmlElement(name = "experience")
    public void setExperiences(List<CV_Experience> experiences) {
        this.experiences = experiences;
    }

    public List<CV_School> getSchools() {
        return schools;
    }

    @XmlElement(name = "school")
    public void setSchools(List<CV_School> schools) {
        this.schools = schools;
    }
}
