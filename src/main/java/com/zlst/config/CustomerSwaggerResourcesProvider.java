package com.zlst.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
public class CustomerSwaggerResourcesProvider implements SwaggerResourcesProvider {
    
	@Autowired
	private ApiDocList apiDocList;
	
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        for (SwaggerProperties swaggerProperties : apiDocList.getList()) {
            resources.add(swaggerResource(swaggerProperties.getName(), "/translate/api-docs/" + swaggerProperties.getName()));
        }
        return resources;
    }
    
    private SwaggerResource swaggerResource(String name, String url) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setUrl(url);
        swaggerResource.setSwaggerVersion("2.0");
        
        return swaggerResource;
    }
}
