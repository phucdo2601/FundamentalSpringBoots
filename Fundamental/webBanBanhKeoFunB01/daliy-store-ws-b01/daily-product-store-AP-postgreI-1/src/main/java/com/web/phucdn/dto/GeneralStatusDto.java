package com.web.phucdn.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralStatusDto implements Serializable {
	private String genStatusCode;
	private String genStatusTitle;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
}
