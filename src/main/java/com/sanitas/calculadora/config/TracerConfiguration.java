package com.sanitas.calculadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class TracerConfiguration {

	@Bean
	public TracerImpl getTracerImp() {
		return new TracerImpl();
	}
}
