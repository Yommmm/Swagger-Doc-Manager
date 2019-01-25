package com.zlst.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zlst.entity.SwaggerProperties;
import com.zlst.entity.SwaggerResources;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zlst.module"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("供应链-基础数据管理")
                .description("powered by chalco-steering.com")
                .termsOfServiceUrl("http://www.chalco-steering.com")
                .version("V2.0")
                .build();
    }
    
    @Bean
    public SwaggerResources getSwaggerResources() {
    	SwaggerResources swaggerResources = new SwaggerResources();
    	List<SwaggerProperties> swaggerPropertiesList = new ArrayList<>();
		SwaggerProperties swaggerPropertiesA = new SwaggerProperties();
		swaggerPropertiesA.setName("BASE");
		swaggerPropertiesA.setUrl("http://gateway.scdev.cs2025.cn/gateway/api-supply-chain-base/v2/api-docs");
		swaggerPropertiesList.add(swaggerPropertiesA);
		
		SwaggerProperties swaggerPropertiesB = new SwaggerProperties();
		swaggerPropertiesB.setName("WMS");
		swaggerPropertiesB.setUrl("http://gateway.scdev.cs2025.cn/gateway/api-supply-chain-wms/v2/api-docs");
		swaggerPropertiesList.add(swaggerPropertiesB);
		
		SwaggerProperties swaggerPropertiesC = new SwaggerProperties();
		swaggerPropertiesC.setName("TMS");
		swaggerPropertiesC.setUrl("http://gateway.scdev.cs2025.cn/gateway/api-supply-chain-base/v2/api-docs");
		swaggerPropertiesList.add(swaggerPropertiesC);
		
		SwaggerProperties swaggerPropertiesD = new SwaggerProperties();
		swaggerPropertiesD.setName("OMS");
		swaggerPropertiesD.setUrl("http://gateway.scdev.cs2025.cn/gateway/api-supply-chain-base/v2/api-docs");
		swaggerPropertiesList.add(swaggerPropertiesD);
		
		swaggerResources.setSwaggerPropertiesList(swaggerPropertiesList);
		return swaggerResources;
    }
    
}
