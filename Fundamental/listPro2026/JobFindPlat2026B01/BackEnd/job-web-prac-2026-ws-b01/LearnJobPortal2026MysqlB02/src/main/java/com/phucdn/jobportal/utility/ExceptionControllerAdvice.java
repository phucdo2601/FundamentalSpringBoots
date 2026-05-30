package com.phucdn.jobportal.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.phucdn.jobportal.exception.JobPortalException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	private Environment environment;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalException(Exception exception) {
		ErrorInfo errorInfo = new ErrorInfo(
				exception.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now()
				
				);
		
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(JobPortalException.class)
	public ResponseEntity<ErrorInfo> generalException(JobPortalException exception) {
		String message = environment.getProperty(exception.getMessage());
		ErrorInfo errorInfo = new ErrorInfo(
				message,
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now()
				
				);
		
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({
		MethodArgumentNotValidException.class, ConstraintViolationException.class
	})
	public ResponseEntity<ErrorInfo> validatorException(Exception exception) {
		String msg = "";
		if (exception instanceof MethodArgumentNotValidException manvException) {
			msg = manvException.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
		} else {
			ConstraintViolationException cvException = (ConstraintViolationException) exception;
			msg = cvException.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
		}
		ErrorInfo errorInfo = new ErrorInfo(
				msg,
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now()
				
				);

		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
