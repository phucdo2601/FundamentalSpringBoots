package com.phucdn.learnRestAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.phucdn.learnRestAPI.model.ErrorMessage;

/**
 * @RestControllerAdvice là một Annotation gắn trên Class. Có tác dụng xen vào
 * quá trình xử lý của các @RestController. Tương tự
 * với @ControllerAdvice
 * @RestControllerAdvice thường được kết hợp với @ExceptionHandler để cắt ngang
 * quá trình xử lý của Controller, và xử lý các ngoại lệ
 * xảy ra.
 * @author ASUS
 *
 */

@RestControllerAdvice
public class ApiExceptionHandler {
	/**
	 * Tat ca exception khong khai bao se duoc xu ly tai day
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleAllException(Exception ex, WebRequest request) {
		//qua trinh kiem soat loi dien ra o day
		return new ErrorMessage(10000, ex.getLocalizedMessage());
	}
	
	/**
	 * IndexOutOfBoundsException se duoc xu ly rieng tai day
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(IndexOutOfBoundsException.class)
	@ResponseStatus(value =  HttpStatus.BAD_REQUEST)
	public ErrorMessage todoClassException(Exception ex, WebRequest request) {
		return new ErrorMessage(10100, "This object is not exsited!");
	}
}
