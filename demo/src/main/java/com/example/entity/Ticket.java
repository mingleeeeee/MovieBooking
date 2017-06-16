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
	@Table(name = "ticket")
	public class Ticket implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long ticket_id;
	 
	 @ManyToOne
	 @JoinColumn(name = "show_id")
	 private Show show ;
	 @ManyToOne
	 @JoinColumn(name = "ticket_type_id")
	 private Ticket_type ticket_type_id;
	 
	 private int amount;
	 
	 public long getTicket_id(){
		 return ticket_id;
	 }
	 
	 public void setTicket_id( long ticket_id){
		 this.ticket_id = ticket_id;
	 }
	 
	 public Show getShow (){
		return show;
	 }
	 
	 public void setShow( Show show){
		 this.show = show;
	 }
	 public Ticket_type getTicket_type_id(){
		return ticket_type_id; 
	 }
	 public void setTicket_type_id( Ticket_type ticket_type_id){
		 this.ticket_type_id = ticket_type_id; 
	 }
	 public int getAmount(){
		 return amount;
	 }
	 public void setAmount( int amount){
		 this.amount = amount;
	 }
	 
	 
	 
	 
}