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
	@Table(name = "hall")
	public class Hall implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long h_id;
	 private String h_floor ;
	
	 
	 public long getH_id() {
		return h_id;
	}
	 public void setH_id(long h_id) {
		this.h_id = h_id;
	}
	 public String getH_floor() {
		return h_floor;
	}
	 public void setH_floor(String h_floor) {
		this.h_floor = h_floor;
	 }
	 
}