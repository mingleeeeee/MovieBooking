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
	@Table(name = "hall")
	public class Hall implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long hall_id;
	 private String hall_floor ;
	 
	 @OneToMany(mappedBy = "show_id")
	 private List<Show> show;
	
	 @OneToMany(mappedBy = "seat_id")
	 private List<Seat> seat;
	 
	 public long getHall_id() {
		return hall_id;
	}
	 public void setHall_id(long hall_id) {
		this.hall_id = hall_id;
	}
	 public String getHall_floor() {
		return hall_floor;
	}
	 public void setHall_floor(String hall_floor) {
		this.hall_floor = hall_floor;
	 }
	 public List<Show> getShow(){
		 return show;
	 }
	 public void setShow( List<Show> show){
		 this.show = show;
	 }
	 public List<Seat> getSeat(){
		 return seat;
	 }
	 public void setSeat( List<Seat> seat){
		 this.seat = seat;
	 }
}