package com.maozi.system.config.properties;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("application-project-system")
public class SystemProperties implements Serializable {
	
	private String projectName;
	
	private String corporationName;
	
	private String icon;
	
	private String environment;
	
	private String description;
	
	private String copyright;

}
