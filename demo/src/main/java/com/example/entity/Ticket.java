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
	 
	 private int show ;
	 private int ticket_type_id;
	 
	 public long getTicket_id(){
		 return ticket_id;
	 }
	 
	 public void setTicket_id( long ticket_id){
		 this.ticket_id = ticket_id;
	 }
	 
	 public int getShow (){
		return show;
	 }
	 
	 public void setShow( int show){
		 this.show = show;
	 }
	 public int getTicket_type_id(){
		return ticket_type_id; 
	 }
	 
	 
	 
	 
	 
}