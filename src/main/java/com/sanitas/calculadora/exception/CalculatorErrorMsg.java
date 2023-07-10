package com.sanitas.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CalculatorErrorMsg {
	private int statusCode;
	private String message;
	private String requestUri;
}
