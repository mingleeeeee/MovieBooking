package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

	 @Entity
	 @Table(name = "users")
	 public class Users implements Serializable {
	 
	 private static final long serialVersionUID = 3316076651716569539L;	
	 
	 //@GeneratedValue(strategy=GenerationType.AUTO)
	 //private long user_id;
	 
	 @OneToMany(mappedBy="user")
	 private List<Authority> authorities;
	 
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	@NotNull(message="不得空白")
	 @Size(min = 1,message="不得空白")
	 private String last_name ;
	 @NotNull(message="不得空白")
	 private String first_name;
	 
	 private String nick_name;
	 
	 @Id
	 @NotNull(message="不得空白")
	 private int username;
	 @NotNull(message="不得空白")
	 private String password;
	 
	 private int enabled = 1;
	 
	 @NotNull(message="不得空白")
	 private int birth;
	 @NotNull(message="不得空白")
	 private int year;
	 @NotNull(message="不得空白")
	 private String address;
	 @NotNull(message="不得空白")
	 private String tel;
	 
	

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
	 public void setUsername(int username){
		 this.username = username;
	 }
	 public int getUsername(){
		 return username;
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
	 public int getEnabled(){
		 return enabled;
	 }
	 public void setEnabled(int enabled){
		 this.enabled = enabled;
	 }
}