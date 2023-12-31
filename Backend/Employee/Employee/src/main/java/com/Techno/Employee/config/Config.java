package com.Techno.Employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


import com.Techno.Employee.entity.EmployeeWithComplaint;

@Configuration
public class Config {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	EmployeeWithComplaint employeeWithComplaint() {
		return new EmployeeWithComplaint();
	}

}
