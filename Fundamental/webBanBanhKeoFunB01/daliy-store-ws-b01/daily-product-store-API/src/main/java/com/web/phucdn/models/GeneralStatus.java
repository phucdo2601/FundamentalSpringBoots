package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "generalStatus_tbl")
public class GeneralStatus extends BaseEntity implements Serializable {
	private String genStatusCode;
	private String genStatusTitle;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
}
