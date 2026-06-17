package com.betacom.pv.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.betacom.pv.dto.output.ResponseDTO;
import com.betacom.pv.interfaces.IMessaggiServices;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionManager {
	private final IMessaggiServices serS;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handleException(Exception e) {
		return ResponseEntity.badRequest()
				.body(ResponseDTO.builder()
						.msg(serS.get(e.getMessage()))
						.build());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleValidationException(MethodArgumentNotValidException e) {
		String msg = e.getBindingResult()
				.getFieldErrors()
				.stream()
				.findFirst()
				.map(FieldError::getDefaultMessage)
				.orElse("Errore Validazione");
		
		return ResponseEntity.badRequest().body(ResponseDTO.builder().msg(serS.get(msg)).build());
	}
}
