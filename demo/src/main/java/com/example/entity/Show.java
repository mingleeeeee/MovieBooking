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
	@Table(name = "movie_show")
	public class Show implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long show_id;
	 
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 private int movie_id ;
	 @NotNull(message="不得空白")
	 private int hall_id;
	 
	 private int time_slot_id;
	 
	 
	 public long getShow_id(){
		 return show_id;
	 }
	 public void setShow_id(int show_id){
		 this.show_id = show_id;
	 }
	 
	 public int getMovie_id(){
		 return movie_id;
	 }
	 public void setMovie_id( int movie_id ){
		 this.movie_id = movie_id;
	 }
	 
	 public int getHall_id(){
		 return hall_id;
	 }
	 public void setHall_id( int hall_id){
		 this.hall_id = hall_id;
	 }
	 
	 public int getTime_slot_id(){
		 return time_slot_id;
	 }
	 public void setTime_slot_id( int time_slot_id ){
		 this.time_slot_id = time_slot_id;
	 }
}