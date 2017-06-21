package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie_category")
public class MovieCategory implements Serializable{
	private static final long serialVersionUID = -2957645392914180170L;
	
	@Id
	private Long id;
	private String name;
	
	
	// mappedBy refers to the variable in Product
	@OneToMany(mappedBy = "movieCategory")
	private List<Movie> movies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Iterable<Movie> getMovies() {
		return movies;
	}
	
/*
	public void setProducts(List<Product> pros) {
		this.product = product;
	}
*/
	/** MySQL SQL Query
	 * 
	 * CREATE TABLE `project`.`product_category` (
	  `id` int(11) NOT NULL AUTO_INCREMENT,
	  `name` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
	  PRIMARY KEY (`id`));
	  
	  
	  CREATE TABLE `project`.`product` (
	  `id` int(11) NOT NULL AUTO_INCREMENT,
	  `description` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
	  `type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
	  `stock` INT NULL,
	  `secure_stock` INT NULL,
	  `category` int(11) DEFAULT NULL,
	  PRIMARY KEY (`id`),
	  KEY `book_category_idx` (`category`),
	  CONSTRAINT `product_category` FOREIGN KEY (`category`) REFERENCES `product_category` (`id`) ON UPDATE CASCADE
	);
	 * 
	 */

}
