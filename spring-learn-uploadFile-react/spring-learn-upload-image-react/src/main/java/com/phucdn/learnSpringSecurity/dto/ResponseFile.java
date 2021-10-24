package com.phucdn.learnSpringSecurity.dto;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFile {
	private String name;
	private String url;
	private String type;
	private long size;
}
