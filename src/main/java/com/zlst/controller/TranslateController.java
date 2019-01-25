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
	
	private RestTemplate getRestTemplate() {
		if(null == restTemplate) {
			restTemplate = new RestTemplate();
			return restTemplate;
		} else {
			return restTemplate;
		}
	}

	@GetMapping("/api-docs/{serviceName}")
	public Object getApiDocs(@PathVariable String serviceName) {
		RestTemplate restTemplate = this.getRestTemplate();
		Map<String, List<SwaggerProperties>> paramMap = this.getParamMap();
		String url = paramMap.get(serviceName).get(0).getUrl();
		return restTemplate.getForObject(url, String.class);
	}
	
}
