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
	 private long id;
	 
	 @NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 private String last_name ;
	 @NotNull(message="不得空白")
	 private String first_name;
	 
	 private String nick_name;
	 
	 @NotNull(message="不得空白")
	 private String username;
	 @NotNull(message="不得空白")
	 private String password;
	 
	 @NotNull(message="不得空白")
	 private int birth;
	 @NotNull(message="不得空白")
	 private int year;
	 @NotNull(message="不得空白")
	 private String address;
	 @NotNull(message="不得空白")
	 private String tel;
	 
	 public long getId(){
		 return this.id;
	 }
	 public void setId( long id){
		 this.id = id;
	 }

	 public String getLast_name(){
		 return last_name;
	 }
	 
	 public void setLast_name( String last_name){
		 this.last_name = last_name;
	 }
	 
	 public String getFirst_name(){
		 return first_name;
	 }
	 
	 public void setFirst_name( String first_name){
		 this.first_name = first_name;
	 }
	 
	 public String getNick_name(){
		 return nick_name;
	 }
	 
	 public void setNick_name( String nick_name){
		 this.nick_name = nick_name;
	 }
	 
	 public String getUsername(){
		 return username;
	 }
	 public void setM_username( String username){
		 this.username = username;
	 }
	 
	 public String getPassword(){
		 return password;
	 }
	 public void setPassword( String password){
		 this.password = password;
	 }
	 
	 public int getBirth(){
		 return birth;
	 }
	 
	 public void setBirth( int birth){
		 this.birth = birth;
	 }
	 
	 public int getYear(){
		 return year;
	 }
	 
	 public void setYear( int year){
		 this.year = year;
	 }
	 
	 public String getAddress(){
	    return address;	 
	 }
	 
	 public void setAddress( String address){
		    this.address = address;	 
		 }
	 
	 public String getTel(){
		 return tel;
	 }
	 
	 public void setTel( String tel){
		 this.tel = tel;
	 }
}