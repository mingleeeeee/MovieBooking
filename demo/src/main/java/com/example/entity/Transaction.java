package com.example.entity;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

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
	@Table(name = "transaction")
	public class Transaction implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long transaction_id;
	 
	 @NotNull(message="")
	 private String name;
	 @NotNull(message="")
	 private int movie;
	 private int time_slot;
	 private int ticket_type;
	 private int amount;
	 private int payment;
	 
	 
	 public long getTransaction_id(){
		 return transaction_id;
	 }
	 
	 public void setTransaction_id( long transaction_id){
		 this.transaction_id = transaction_id;
	 }
	 
	 public String getName (){
		return name;
	 }
	 public void setName( String name){
		 this.name = name;
	 }
	 
	 public int getMovie(){
		return movie; 
	 }
	 public void setMovie( int movie){
		 this.movie = movie;
	 }
	 
	 public int getTime_slot(){
		 return time_slot;
	 }
	 public void setTime_slot( int time_slot){
		 this.time_slot= time_slot;
	 }
	 
	 public int getTicket_type(){
		 return ticket_type;
	 }
	 public void setTicket_type( int ticket_type){
		 this.ticket_type = ticket_type;
	 }
	 
	 public int getAmount(){
		return amount;
	 }
	 public void setAmount( int amount){
		 this.amount = amount;
	 }
	 
	 public int getPayment(){
		 return payment;
	 }
	 public void setPayment( int payment){
		 this.payment = payment;
	 }
	 
}