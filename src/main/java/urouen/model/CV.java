package urouen.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "cv")
public class CV {

    private String id;
    private String gender;
    private CV_Name name;
    private String firstname;

    public CV() {
        super();
    }

    public CV(CV_Name name, String firstname) {
        this.id = null;
        this.name = name;
        this.firstname = firstname;
    }

    public CV(String id, String gender, CV_Name name, String firstname) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.firstname = firstname;
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
}
