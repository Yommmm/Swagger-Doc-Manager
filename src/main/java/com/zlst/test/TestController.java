package com.zlst.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlst.config.ApiDocList;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private ApiDocList apiDocList;

	@GetMapping("/configInfo")
	public Object test() {
		return apiDocList.getList();
	}
	
}
