package com.crm;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class  CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	//@Bean   //BEST PRACTICE IS TO IMPLEMENT THIS CLASS IN CONFIG CLASS
	//public ModelMapper getMapper() {
	//	return new ModelMapper();
	//}
}
