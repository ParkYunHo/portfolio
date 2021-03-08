package com.portfolio.yoonho.config;

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
	public Docket userMgmtAPI_dev() {
		String version = "dev";
		String title = "사용자 관리 개발용 API";
		
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.groupName(version)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.portfolio.yoonho.controller.api.userMgmt.dev"))
				.paths(PathSelectors.ant("/api/dev/**"))
				.build()
				.apiInfo(apiInfo(title, version));
	}
	
	@Bean
	public Docket userMgmtAPI_ops() {
		String version = "ops";
		String title = "사용자 관리 API";
		
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.groupName(version)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.portfolio.yoonho.controller.api.userMgmt.ops"))
				.paths(PathSelectors.ant("/api/**"))
				.build()
				.apiInfo(apiInfo(title, version));
	}
	
	
	private ApiInfo apiInfo(String title, String version) {
		return new ApiInfoBuilder()
				.title(title)
				.description("Swagger API Docs")
				.version(version)
				.build();
	}
}
