package com.zlst.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.zlst.entity.SwaggerProperties;
import com.zlst.entity.SwaggerResources;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
public class CustomerSwaggerResourcesProvider implements SwaggerResourcesProvider {
    
	private SwaggerResources swaggerResources;

    public CustomerSwaggerResourcesProvider(SwaggerResources swaggerResources) {
        this.swaggerResources = swaggerResources;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        for (SwaggerProperties swaggerProperties : swaggerResources.getSwaggerPropertiesList()) {
            resources.add(swaggerResource(swaggerProperties.getName(), swaggerProperties.getUrl()));
        }
        return resources;
    }
    
    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
