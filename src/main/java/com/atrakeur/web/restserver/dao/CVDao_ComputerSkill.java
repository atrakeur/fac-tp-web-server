package com.atrakeur.web.restserver.dao;

import com.atrakeur.web.restserver.model.CV_ComputerSkill;

public class CVDao_ComputerSkill {

    private String name;
    private int level;

    public CVDao_ComputerSkill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public CVDao_ComputerSkill(CV_ComputerSkill lang) {
        this.name = lang.getName();
        this.level = lang.getLevel();
    }

    public CV_ComputerSkill toCVComputerSkill() {
        return new CV_ComputerSkill(this.name, this.level);
    }

}
