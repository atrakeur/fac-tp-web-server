package urouen.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cv")
public class CV {

    String id;
    String name;
    String firstname;

    public CV() {
        super();
    }

    public CV(String name, String firstname) {
        this.id = null;
        this.name = name;
        this.firstname = firstname;
    }

    public CV(String id, String name, String firstname) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
}