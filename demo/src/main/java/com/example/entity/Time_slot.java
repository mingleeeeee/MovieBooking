package com.example.entity;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

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
	@Table(name = "time_slot")
	public class Time_slot implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long time_slot_id;
	 
	 private int time_slot_beginning;
	 private int time_slot_ending; 
	 private String time_slot_date;
	 
 
	 public long getTime_slot_id(){
		 return time_slot_id;
	 }
	 
	 public void setTime_slot_id( long time_slot_id){
		 this.time_slot_id = time_slot_id;
	 }
	 
	 public int getTime_slot_beginning (){
		return time_slot_beginning;
	 }
	 public void setTime_slot_beginning( int time_slot_beginning){
		 this.time_slot_beginning = time_slot_beginning;
	 }
	 
	 public int getTime_slot_ending(){
		return time_slot_ending; 
	 }
	 public void setTime_slot_ending( int time_slot_ending){
		 this.time_slot_ending = time_slot_ending;
	 }
	 
	 public String getTime_slot_date(){
		 return time_slot_date;
	 }
	 public void setTime_slot_date( String time_slot_date){
		 this.time_slot_date = time_slot_date;
	 }
	
	 
	 
}