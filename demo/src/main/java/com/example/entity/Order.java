package com.example.entity;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Order implements Serializable {
	private static final long serialVersionUID = 3316076651716569539L;	
	
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	
	private int show_id;
	private int ticket_type_id;
	private String ticket_type_name;
	private int price;
	private int amount;
	private int total;
	
	
	public long getId(){
		return id;
	}
	public void setId( long id){
	 	this.id = id;
	}
	public int getShow_id(){
		return show_id;
	}
	public void setShow_id( int show_id){
		this.show_id = show_id;
	}
	
	public int getTicket_type_id(){
		return ticket_type_id;
	}
	public void setTicket_type_id( int ticket_type_id){
		this.ticket_type_id = ticket_type_id;
	}
	public String getTicket_type_name(){
		return ticket_type_name;
	}
	public void setTicket_type_name(  String ticket_type_name){
		this.ticket_type_name = ticket_type_name;
	}
	public int getPrice(){
		return price;
	}
	public void setPrice( int price){
		this.price = price;
	}
	public int getAmount(){
		return amount;
	}
	public void setAmount(int amount){
		this.amount = amount;
	}
	public void setAmount(HttpServletRequest request ,HttpServletResponse response) 
			throws ServletException, IOException 
	{
	    this.amount = request.getIntHeader("amount");
	   
	}
	public int getTotal(){
		return price * amount ;
	}
	public void setTotal( int total ){
		this.total = total;
	}
	//HttpServletRequest request
}
