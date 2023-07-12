package com.sanitas.calculadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

/**
 * The Class TracerConfiguration.
 */
@Configuration
public class TracerConfiguration {

	/**
	 * Gets the tracer imp.
	 *
	 * @return the tracer imp
	 */
	@Bean
	public TracerImpl getTracerImp() {
		return new TracerImpl();
	}
}
