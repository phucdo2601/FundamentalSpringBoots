package com.phucdn.learnRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Tạo ra class ErrorMessage để chứa thông tin trả về cho Client.
 * @author ASUS
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	private int statusCode;
	private String message;
}
