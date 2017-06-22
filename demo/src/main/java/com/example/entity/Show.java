package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@Entity
	@Table(name = "movie_show")
	public class Show implements Serializable {
	 
	private static final long serialVersionUID = 3316076651716569539L;	
	
	 @Id
	 private long show_id;	  
	
	 @ManyToOne
	 @JoinColumn(name = "movie_id")
	 private Movie movie_id;
	 @ManyToOne
	 @JoinColumn(name = "hall_id")
	 private Hall hall_id;
	 @ManyToOne
	 @JoinColumn(name = "time_slot_id")
	 private Time_slot time_slot_id;
	 
	 //@OneToMany(mappedBy = "show_id")
	 //private List<SeatAvailability> seatAvai;
	 @OneToMany(mappedBy = "show")
	 private List<SeatAvailability> seatAvailability;
	 
	 public long getShow_id(){
		 return show_id;
	 }
	 public void setShow_id(int show_id){
		 this.show_id = show_id;
	 }
	 public Movie getMovie_id(){
		 return movie_id;
	 }
	 public void setMovie_id( Movie movie_id ){
		 this.movie_id = movie_id;
	 } 
	 public Hall getHall_id(){
		 return hall_id;
	 }
	 public void setHall_id( Hall hall_id){
		 this.hall_id = hall_id;
	 } 
	 public Time_slot getTime_slot_id(){
		 return time_slot_id;
	 }
	 public void setTime_slot_id( Time_slot time_slot_id ){
		 this.time_slot_id = time_slot_id;
	 }
	 /**
	 public List<SeatAvailability> getSeatAvai(){
		 return this.seatAvai;
	 }
	 public void setSeatAvai( List<SeatAvailability> seatAvai){
		 this.seatAvai = seatAvai;
	 }
	**/
	 public List<SeatAvailability> getSeatAvailability() {
			return seatAvailability;
		}

		public void setSeatAvailability(List<SeatAvailability> seatAvailability) {
			this.seatAvailability = seatAvailability;
		}
}