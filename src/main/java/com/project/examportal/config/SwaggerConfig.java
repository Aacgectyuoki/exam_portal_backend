package com.project.examportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuration class for Swagger documentation in the Exam Portal project.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Configures the Swagger Docket for the API.
     *
     * @return Docket instance for Swagger documentation.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Provides API information for Swagger documentation.
     *
     * @return ApiInfo instance with project details.
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Exam Portal API Documentation",
                "This API documentation belongs to the Exam Portal project developed by Max Dell-Thibodeau.",
                "Version 1.0",
                "Terms of Service",
                new Contact("Max Dell-Thibodeau", "https://dtwebsolutions.org/", "maxd4637@gmail.com"),
                "API License",
                "https://example.com/api-license",
                Collections.emptyList()
        );
    }
}
