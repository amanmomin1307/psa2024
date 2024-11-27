package com.crm.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {

    @Bean //  I CAN ALSO IMPLEMENT THIS IN CRM APPLICATION FILE
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
}
