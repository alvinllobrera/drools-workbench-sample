/*
 * Copyright (c) 2015, CloudSherpas Incorporated. All rights reserved.
 */
package com.cloudsherpas.courseadvisor.services.impl;

import com.cloudsherpas.courseadvisor.facts.CourseSuggestion;
import com.cloudsherpas.courseadvisor.facts.SubjectPreference;
import com.cloudsherpas.courseadvisor.services.CourseAdvisorService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class CourseAdvisorServiceImpl implements CourseAdvisorService {

    @Inject
    private KieContainer kieContainer;

    @Override
    public CourseSuggestion suggestCourses(List<SubjectPreference> subjectPreferences) {
        CourseSuggestion courseSuggestion = new CourseSuggestion();
        StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("CourseAdvisorKS");
        statelessKieSession.setGlobal("suggestions", courseSuggestion);
        statelessKieSession.execute(subjectPreferences);
        return courseSuggestion;
    }
}
