package com.maozi.system.config.properties;

import java.io.Serializable;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
