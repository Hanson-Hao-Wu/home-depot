package org.hao.homedepot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerReviewModel {
	
	private Double rating;
	private String headline;
	private String comment;
	private UserModel user;
	private ProductModel product;

}
