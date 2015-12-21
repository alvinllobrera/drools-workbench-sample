/*
 * Copyright (c) 2015, CloudSherpas Incorporated. All rights reserved.
 */
package com.cloudsherpas.courseadvisor.facts;

public class SubjectPreference {
    private String subjectCode;
    private int rating;

    public SubjectPreference() {

    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "SubjectPreference{" +
                "subjectCode='" + subjectCode + '\'' +
                ", rating=" + rating +
                '}';
    }
}
