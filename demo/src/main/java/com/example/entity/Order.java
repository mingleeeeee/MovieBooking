package com.example.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Order implements Serializable {
	private static final long serialVersionUID = 3316076651716569539L;	
	
	private int show_id;
	private int ticket_type_id;
	private int price;
	private int amount;
	private int total;
	
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
	public int getTotal(){
		return total;
	}
	public void setTotal( int total ){
		this.total = total;
	}

}
