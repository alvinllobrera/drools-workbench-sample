/*
 * Copyright (c) 2015, CloudSherpas Incorporated. All rights reserved.
 */
package com.cloudsherpas.courseadvisor.configs;

import com.cloudsherpas.courseadvisor.utils.DroolsConfigConstants;
import org.drools.core.io.impl.UrlResource;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@PropertySource("WEB-INF/configs/drools-workbench.properties")
public class DroolsConfiguration {

    @Inject
    private Environment env;

    @Bean
    public KieContainer kieContainer() throws IOException {
        final String url = env.getProperty(DroolsConfigConstants.WB_URL) +
                env.getProperty(DroolsConfigConstants.WB_REPO_PATH) +
                env.getProperty(DroolsConfigConstants.WB_ARTIFACT_PATH) +
                env.getProperty(DroolsConfigConstants.WB_ARTIFACT_NAME);

        KieServices ks = KieServices.Factory.get();
        KieRepository repo = ks.getRepository();
        KieResources resources = ks.getResources();
        UrlResource urlResource = (UrlResource) ks.getResources()
                .newUrlResource(url);
        urlResource.setUsername(env.getProperty(DroolsConfigConstants.WB_USERNAME));
        urlResource.setPassword(env.getProperty(DroolsConfigConstants.WB_PASSWORD));
        urlResource.setBasicAuthentication("enabled");
        InputStream is = urlResource.getInputStream();
        KieModule k = repo.addKieModule(resources.newInputStreamResource(is));

        return ks.newKieContainer(k.getReleaseId());
    }
}