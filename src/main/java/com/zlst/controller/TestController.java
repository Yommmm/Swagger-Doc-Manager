package com.zlst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlst.entity.SwaggerResources;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private SwaggerResources swaggerResources;

	@GetMapping("/configInfo")
	public Object test() {
		return swaggerResources.getSwaggerPropertiesList();
	}
	
}
