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
	@Table(name = "member")
	public class Member implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long m_id;
	 
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 private String m_last_name ;
	 @NotNull(message="不得空白")
	 private String m_first_name;
	 
	 private String m_nick_name;
	 
	 @NotNull(message="不得空白")
	 private String m_username;
	 @NotNull(message="不得空白")
	 private String m_password;
	 
	 @NotNull(message="不得空白")
	 private int m_birth;
	 @NotNull(message="不得空白")
	 private int m_year;
	 
	 private String m_address;
	 private String m_tel;
	 
	 public long getM_id(){
		 return this.m_id;
	 }
	 public void setM_id( long m_id){
		 this.m_id = m_id;
	 }

	 public String getM_last_name(){
		 return m_last_name;
	 }
	 
	 public void setM_last_name( String m_last_name){
		 this.m_last_name = m_last_name;
	 }
	 
	 public String getM_first_name(){
		 return m_first_name;
	 }
	 
	 public void setM_first_name( String m_first_name){
		 this.m_first_name = m_first_name;
	 }
	 
	 public String getM_nick_name(){
		 return m_nick_name;
	 }
	 
	 public void setM_nick_name( String m_nick_name){
		 this.m_nick_name = m_nick_name;
	 }
	 
	 public String getM_username(){
		 return m_username;
	 }
	 public void setM_username( String m_username){
		 this.m_username = m_username;
	 }
	 
	 public String getM_password(){
		 return m_password;
	 }
	 public void setM_password( String m_password){
		 this.m_password = m_password;
	 }
	 
	 public int getM_birth(){
		 return m_birth;
	 }
	 
	 public void setM_birth( int m_birth){
		 this.m_birth = m_birth;
	 }
	 
	 public int getM_year(){
		 return m_year;
	 }
	 
	 public void setM_year( int m_year){
		 this.m_year = m_year;
	 }
	 
	 public String getM_address(){
	    return m_address;	 
	 }
	 
	 public void setM_address( String m_address){
		    this.m_address = m_address;	 
		 }
	 
	 public String getM_tel(){
		 return m_tel;
	 }
	 
	 public void setM_tel( String m_tel){
		 this.m_tel = m_tel;
	 }
}