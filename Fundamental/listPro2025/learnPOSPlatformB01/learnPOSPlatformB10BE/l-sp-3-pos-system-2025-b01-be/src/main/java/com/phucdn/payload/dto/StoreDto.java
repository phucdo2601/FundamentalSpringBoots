package com.phucdn.payload.dto;

import java.time.LocalDateTime;

import com.phucdn.domain.StoreContact;
import com.phucdn.domain.StoreStatus;
import com.phucdn.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {
	private Long id;
	private String brand;
	private UserDto storeAdmin;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String description;
	private String storeType;
	private StoreStatus status;
	private StoreContact contact;
}
