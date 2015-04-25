package com.atrakeur.web.restserver.dao;

import com.atrakeur.web.restserver.model.CV_Experience;

import java.util.Date;

public class CVDao_Experience {
    private String text;
    private Date begin;
    private Date end;

    public CVDao_Experience(CV_Experience exp) {
        this.text = exp.getText();
        this.begin = exp.getBegin();
        this.end = exp.getEnd();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public CV_Experience toCVExperience() {
        return new CV_Experience(this.text, this.begin, this.end);
    }
}
