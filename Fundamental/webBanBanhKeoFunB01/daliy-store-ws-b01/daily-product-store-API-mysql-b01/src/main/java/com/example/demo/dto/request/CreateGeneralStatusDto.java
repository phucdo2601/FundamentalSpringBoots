package com.example.demo.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGeneralStatusDto implements Serializable {
	private String genStatusCode;
	private String genStatusTitle;
}
