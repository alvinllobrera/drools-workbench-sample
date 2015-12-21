/*
 * Copyright (c) 2015, CloudSherpas Incorporated. All rights reserved.
 */
package com.cloudsherpas.courseadvisor.commons.util;

import com.cloudsherpas.courseadvisor.commons.facts.Course;

public class CourseFactory {

    public static Course createCourse(final String courseCode) {
        final Course course = new Course();
        course.setCode(courseCode);

        if (courseCode.equals("BSA")) {
            course.setDescription("BS in Accountancy");
        } else if (courseCode.equals("BSCS")) {
            course.setDescription("BS in Computer Science");
        } else if (courseCode.equals("Physics")) {
            course.setDescription("BS in Physics");
        }

        return course;
    }
}
