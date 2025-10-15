package com.phucdn.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Home {

	private List<HomeCategory> grid;
	private List<HomeCategory> shopByCategories;
	private List<HomeCategory> electricCategories;
	private List<HomeCategory> dealCategories;
	private List<Deal> deals;
	
}
