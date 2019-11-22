package com.neuedu.ssm.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -382509290178746427L;

	private Integer id;	
	private String productName;
	private String productDescription;
	private BigDecimal normalprice;
	private BigDecimal memberprice;
	private Timestamp productDate;
	private Category category;
	private String paoductImgpath;
	public Product(String productName, String productDescription, BigDecimal normalprice, Category category,
			String paoductImgpath) {
		
		this.productName = productName;
		this.productDescription = productDescription;
		this.normalprice = normalprice;
		this.memberprice = normalprice.multiply(BigDecimal.valueOf(0.8));
		this.category = category;
		this.paoductImgpath = paoductImgpath;
	}
	
}
