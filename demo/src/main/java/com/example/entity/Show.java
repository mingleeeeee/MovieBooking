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
	public class Show implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long s_id;
	 
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 private String s_name ;
	 @NotNull(message="不得空白")
	 private String m_first_name;
	public long getS_id() {
		return s_id;
	}
	public void setS_id(long s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getM_first_name() {
		return m_first_name;
	}
	public void setM_first_name(String m_first_name) {
		this.m_first_name = m_first_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
}