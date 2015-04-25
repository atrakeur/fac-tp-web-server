package com.atrakeur.web.restserver.dao;

import com.atrakeur.web.restserver.model.CV_Name;

public class CVDao_Name {

    private String name;
    private boolean maiden;

    public CVDao_Name(CV_Name name) {
        this.name = name.getName();
        this.maiden = name.isMaiden();
    }

    public CV_Name toCVName() {
        return new CV_Name(name, maiden);
    }
}
