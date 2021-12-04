package com.phucdn.learnSpringSecurity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataInputDto {

	private List<String> ids;
}
