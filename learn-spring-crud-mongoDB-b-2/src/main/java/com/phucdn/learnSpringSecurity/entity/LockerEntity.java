package com.phucdn.learnSpringSecurity.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lokers")

public class LockerEntity extends BaseEntity{

	@Field(name = "locker_code")
	private String lockerCode;
	@Field(name = "locker_name")
	private String lockerName;
	@Field(name = "storage")
	private int storage;
	@Field(name = "emp_in_dep_id")
	private String empInDepId;
	
	@Field(name = "is_block")
	private boolean isBlock;
	
}
