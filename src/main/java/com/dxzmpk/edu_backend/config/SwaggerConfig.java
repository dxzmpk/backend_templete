package com.dxzmpk.edu_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.dxzmpk.edu_backend.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiEndPointsInfo())
            .useDefaultResponseMessages(false);
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("EDU_BACKEND REST API")
                .description("this is the backend service of a edu system")
                .license("no License yet")
                .version("V-dev")
                .build();
    }
}
