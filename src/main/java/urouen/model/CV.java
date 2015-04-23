package urouen.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cv")
public class CV {

    String name;
    String firtname;
    int age;

    public String getFirtname() {
        return firtname;
    }

    @XmlElement
    public void setFirtname(String firtname) {
        this.firtname = firtname;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public CV(String name, String firtname, int age) {
        this.name = name;
        this.firtname = firtname;
        this.age = age;
    }

    public CV() {
        super();
    }



}