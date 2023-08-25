package com.example.javaRecordCRUD.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "17 Record Ex",
                description = "Springboot 3.1.2 Product Ex",
                version = "1.0.0"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi Product() {
        String[] paths = {"/api/products/**"};

        return GroupedOpenApi.builder()
                .group("Product CRUD")
                .pathsToMatch(paths)
                .build();
    }


//    @Bean
//    public Docket product() {
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(false)
//                .groupName("상품 CRUD")
//                .apiInfo(this.apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.javaRecordCRUD"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Toy-Project")
//                .description("Java17 JPA Record ProductCRUD")
//                .version("1.0.0")
//                .contact(new Contact("권오수", "https://github.com/kwonohsoo", "kwon524@naver.com"))
//                .build();
//    }
}
