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
	@Table(name = "seat")
	public class Seat implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long seat_id;
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 
	 private String h_id ;
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 
	 public long getSeat_id() {
		return seat_id;
	 }
	 public void setSeat_id(long seat_id) {
		this.seat_id = seat_id;
	 }
	 public String getH_id() {
		return h_id;
	 }
	 public void setH_id(String h_id) {
		this.h_id = h_id;
	 }
	 
	 
	
	 
}