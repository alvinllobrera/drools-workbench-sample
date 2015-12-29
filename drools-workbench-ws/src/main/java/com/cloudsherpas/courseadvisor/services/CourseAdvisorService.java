/*
 * Copyright (c) 2015, CloudSherpas Incorporated. All rights reserved.
 */
package com.cloudsherpas.courseadvisor.services;

import com.cloudsherpas.courseadvisor.commons.facts.CourseSuggestion;
import com.cloudsherpas.courseadvisor.commons.facts.SubjectPreference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseAdvisorService {
    CourseSuggestion suggestCourses(List<SubjectPreference> subjectPreferences);
}