package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

	@Entity
	@Table(name = "product")
	public class Product implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	 
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 private String description ;
	 
	 private String type;
	 
	 @Min(value = 0,message = "數值須大於0")
	 private int stock;
	 @Min(value = 0,message = "數值須大於0")
	 private int secure_stock;
	 
	// JoinColumn refers to the column name in the table
		@ManyToOne
		@JoinColumn(name = "category")
		private ProductCategory productCategory;

	
	 public long getId(){
		 return id;
	 }
	 public void setId( long id){
		 this.id = id;
	 }
	 
	 public String getDescription() {
	  return description;
	}
	public void setDescription(String description) {
	 this.description = description;
	 
	}
	
	public String getType() {
	  return type;
	 }
	 public void setType(String type) {
	  this.type = type;
	 }
	
	 public int getStock() {
	  return stock;
	 }
	 public void setStock(int stock) {
	  this.stock = stock;
	 }
	
	 public int getSecure_stock() {
	  return secure_stock;
	 }
	 public void setSecure_stock(int secure_stock) {
	  this.secure_stock = secure_stock;
	 }
	 
	 public ProductCategory getProductCategory(){
		 return productCategory;
	 }
	 
	 public void setProductCategory( ProductCategory productCategory){
		 this.productCategory = productCategory;
	 }
}