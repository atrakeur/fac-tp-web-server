package urouen.dao;

import urouen.model.CV_Lang;

public class CVDao_Lang {

    private String name;
    private int level;
    private String description;

    public CVDao_Lang(String name, int level, String description) {
        this.name = name;
        this.level = level;
        this.description = description;
    }

    public CVDao_Lang(CV_Lang lang) {
        this.name = lang.getName();
        this.level = lang.getLevel();
        this.description = lang.getDescription();
    }

    public CV_Lang toCVLang() {
        return new CV_Lang(this.name, this.level, this.description);
    }

}
