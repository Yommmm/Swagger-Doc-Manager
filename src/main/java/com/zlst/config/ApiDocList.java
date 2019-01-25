package com.zlst.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "apidoclist")
public class ApiDocList {

    private List<SwaggerProperties> list;

	public List<SwaggerProperties> getList() {
		return list;
	}

	public void setList(List<SwaggerProperties> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ApiDocList [list=" + list + "]";
	}

}
