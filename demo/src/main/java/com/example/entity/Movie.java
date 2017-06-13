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
	@Table(name = "movie")
	public class Movie implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long movie_id;
	 
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 private String movie_name ;
	 
	 public long getMovie_id(){
		 return movie_id;
	 }
	 public void setMovie_id( long movie_id ){
		 this.movie_id = movie_id;
	 }
	 
	 public String getMovie_name() {
		 return movie_name;
	 }
	 public void setMovie_name( String movie_name){
		 this.movie_name = movie_name;
	 }
	 
	 
	 
}