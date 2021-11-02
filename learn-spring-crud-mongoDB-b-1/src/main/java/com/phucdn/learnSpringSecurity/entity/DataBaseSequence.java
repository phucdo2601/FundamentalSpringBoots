package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "database_sequences")
public class DataBaseSequence implements Serializable {
	@Id
	private String id;
	private long seq;
}
