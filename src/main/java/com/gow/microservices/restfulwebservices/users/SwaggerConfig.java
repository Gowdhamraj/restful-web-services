package com.gow.microservices.restfulwebservices.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    private static final ApiInfo API_INFO = new ApiInfoBuilder()
            .title("User Resource API")
            .version("0.0.1")
            .contact(new Contact("devWog", "", ""))
            .build();

    private static final Set<String> PRODUCES_CONSUMES = new HashSet<>();
    @Bean
    public Docket api()
    {
        PRODUCES_CONSUMES.add("application/json");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .produces(PRODUCES_CONSUMES)
                .consumes(PRODUCES_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gow.microservices"))
                .build();
    }
}
