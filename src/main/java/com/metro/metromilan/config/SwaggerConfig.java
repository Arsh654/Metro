package com.metro.metromilan.config;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@EnableSwagger2
//
//public class swaggerConfig {
//}
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.jetbrains.annotations.NotNull;
import jakarta.validation.constraints.NotNull;
//import javax.validation.constraints.NotNull;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", name = "enabled", havingValue = "true")
public class SwaggerConfig {

    @Value("${swagger.api.title}")
    private String title;

    @Value("${swagger.api.version}")
    private String version;

    @Value("${swagger.api.description}")
    private String description;

    @Value("${swagger.api.licenseText}")
    private String licenseText;

    @Value("${swagger.contact.name}")
    private String contactName;

    @Value("${swagger.contact.email}")
    private String contactEmail;

    @Value("${swagger.contact.url}")
//    @jakarta.validation.constraints.NotNull
    private String contactUrl;

    //TODO: exclude actuator endpoints
    @Bean
    public @NotNull Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.guardhat.analytics"))
                .paths(PathSelectors.regex(".*/new/user.*"))
                .build().apiInfo(getApiInfo());
    }

    private @NotNull ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .version(version)
                .description(description)
                .license(licenseText)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .build();
    }

}
