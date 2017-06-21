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

import org.springframework.web.multipart.MultipartFile;

	 @Entity
	 @Table(name = "movie")
	 public class Movie implements Serializable {
	 
	 private static final long serialVersionUID = 3316076651716569539L;	
	
	 @Id
	 private long movie_id;
	 private String movie_name ;
	 
	 private transient MultipartFile photoFile;
	 private String photo;
	 private String content;
	 
	 @ManyToOne
	@JoinColumn(name = "category")
	private MovieCategory movieCategory;
	 
	 @OneToMany(mappedBy = "movie_id")
	 private List<Show> movie_show;
	 
	 @OneToMany(mappedBy = "time_slot_id")
	 private List<Time_slot> time_slot ;
 
	 public long getMovie_id(){
		 return movie_id;
	 }
	 public void setMovie_id( long movie_id ){
		 this.movie_id = movie_id;
	 } 
	 public String getMovie_name() {
		 return movie_name;
	 }
	 public void setMovie_name( String movie_name){
		 this.movie_name = movie_name;
	 } 
	 public MultipartFile getPhotoFile() {
		  return photoFile;
		 }	 
	 public void setPhotoFile(MultipartFile photoFile) {
		  this.photoFile = photoFile;
		 }
	 public void setPhoto() {
		  this.photo = photoFile.getOriginalFilename();
		 }
	 public String getPhoto() {
		  return photo;
		 }
	 public void setPhoto(String photo) {
		  this.photo = photo;
		 } 	 	 
	 public List<Show> getMovie_show(){
		 return movie_show;
	 }
	 public void setMovie_show( List<Show> movie_show){
		 this.movie_show = movie_show;
	 }
	 public List<Time_slot> getTime_slot(){
		 return time_slot;
	 }
	 public void setTime_slot( List<Time_slot> time_slot){
		 this.time_slot = time_slot;
	 }
	 public String getContent(){
		 return content;
	 }
	 public void setContent( String content){
		 this.content = content;
	 }
	 public MovieCategory getMovieCategory(){
		 return movieCategory;
	 }
	 public void setMovieCategory( MovieCategory movieCategory){
		 this.movieCategory = movieCategory;
	 }
	 
}