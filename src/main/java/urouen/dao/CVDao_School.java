package urouen.dao;

import urouen.model.CV_Experience;
import urouen.model.CV_School;

import java.util.Date;

public class CVDao_School {

    private String text;
    private Date begin;
    private Date end;

    public CVDao_School(CV_School exp) {
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

    public CV_School toCVSchool() {
        return new CV_School(this.text, this.begin, this.end);
    }

}
