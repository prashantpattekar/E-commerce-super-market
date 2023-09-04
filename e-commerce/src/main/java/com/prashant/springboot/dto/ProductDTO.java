package com.prashant.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private Long id;
	private String name;
	
	private int  categoryId;
	private double price;
	private double weight;
	private String description;
	private String imageName;

}
