/*
 * Copyright (c) 2015, CloudSherpas Incorporated. All rights reserved.
 */
package com.cloudsherpas.courseadvisor.facts;

import java.util.ArrayList;
import java.util.List;

public class CourseSuggestion {
    List<Course> suggestedCourses;

    public List<Course> getSuggestedCourses() {
        return suggestedCourses;
    }

    public void setSuggestedCourses(List<Course> suggestedCourses) {
        this.suggestedCourses = suggestedCourses;
    }

    public void addCourseSuggestion(final Course course) {
        if (suggestedCourses == null) {
            suggestedCourses = new ArrayList<>();
        }
        suggestedCourses.add(course);
    }
}
