/*
 * Copyright (c) 2015, CloudSherpas Incorporated. All rights reserved.
 */
package com.cloudsherpas.courseadvisor.endpoints;

import com.cloudsherpas.courseadvisor.facts.CourseSuggestion;
import com.cloudsherpas.courseadvisor.facts.SubjectPreference;
import com.cloudsherpas.courseadvisor.services.CourseAdvisorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/courseadvisor")
public class CourseAdvisorResource {

    @Inject
    private CourseAdvisorService courseAdvisorService;

    @RequestMapping(value="/suggest-course", method= RequestMethod.POST)
    public @ResponseBody CourseSuggestion suggestCourse(@RequestBody List<SubjectPreference> subjectPreferences) {
        return courseAdvisorService.suggestCourses(subjectPreferences);
    }
}
