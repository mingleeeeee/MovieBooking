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
	@Table(name = "seat_availability")
	public class SeatAvailability implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long avai_id;
	 @ManyToOne
	 @JoinColumn(name = "show_id")
	 private Show show;
	 
	 @ManyToOne
	 @JoinColumn(name = "seat_id")
	 private Seat seat_id;
	 
	 private int available;
	 
	 
	 public long getAvai_id() {
		return avai_id;
	 }
	 public void setAvai_id(long avai_id) {
		this.avai_id = avai_id;
	 }
	 public Show getShow() {
		return show;
	 }
	 public void setShow(Show show) {
		this.show = show;
	 }
	 public Seat getSeat_id(){
		 return seat_id;
	 }
	 public void setSeat_id( Seat seat_id){
		 this.seat_id = seat_id;
	 }
	 public int getAvailable(){
		 return available;
	 }
	 public void setAvailable( int avai_id){
		 this.avai_id = avai_id;
	 }
	 
	 
	 
	
	 
}