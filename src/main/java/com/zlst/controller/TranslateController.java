package com.zlst.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zlst.config.ApiDocList;
import com.zlst.config.SwaggerProperties;

@RestController
@RequestMapping("/translate")
public class TranslateController {
	
	@Autowired
	private ApiDocList apiDocList;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Map<String, List<SwaggerProperties>> paramMap;
	
	private Map<String, List<SwaggerProperties>> getParamMap() {
		if(null == paramMap) {
			List<SwaggerProperties> swaggerPropertiesList = apiDocList.getList();
			Map<String, List<SwaggerProperties>> collect = swaggerPropertiesList.stream().collect(Collectors.groupingBy(SwaggerProperties::getName));
			return collect;
		} else {
			return paramMap;
		}
	}
	

	@GetMapping("/api-docs/{serviceName}")
	public Object getApiDocs(@PathVariable String serviceName) {
		Map<String, List<SwaggerProperties>> paramMap = this.getParamMap();
		SwaggerProperties swaggerProperties = paramMap.get(serviceName).get(0);
		String url = swaggerProperties.getUrl();
		if(swaggerProperties.isRibbon()) {
			return restTemplate.getForObject(url, String.class);
		} else {
			RestTemplate restTemplate4Else = new RestTemplate();
			return restTemplate4Else.getForObject(url, String.class);
		}
	}
	
}
