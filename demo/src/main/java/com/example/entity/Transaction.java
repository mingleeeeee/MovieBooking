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
	@Table(name = "show")
	public class Transaction implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long tr_id;
	 
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 private String tr_price ;
	 @NotNull(message="不得空白")
	 private String tr_time;
	public long getTr_id() {
		return tr_id;
	}
	public void setTr_id(long tr_id) {
		this.tr_id = tr_id;
	}
	public String getTr_price() {
		return tr_price;
	}
	public void setTr_price(String tr_price) {
		this.tr_price = tr_price;
	}
	public String getTr_time() {
		return tr_time;
	}
	public void setTr_time(String tr_time) {
		this.tr_time = tr_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
}