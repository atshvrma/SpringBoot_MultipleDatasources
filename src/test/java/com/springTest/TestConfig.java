package com.springTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springTest.service.OperationsOnDiffDB;
import com.springTest.service.impl.OperationsOnDiffDBImpl;

@Configuration
public class TestConfig {

	@Bean
	public OperationsOnDiffDB operations() {
		return new OperationsOnDiffDBImpl();
	}
	
	
	
	
}
