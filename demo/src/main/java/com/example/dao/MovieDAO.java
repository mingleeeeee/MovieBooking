package com.example.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entity.Movie;
import com.example.entity.MovieCategory;

public interface MovieDAO extends CrudRepository<Movie, Long>{
	@Query("select m from Movie m where m.movie_name LIKE %?1%")
	public Iterable<Movie> findByMovieNameLike(String movieName);
	
	public Iterable<Movie> findByMovieCategory(MovieCategory category);
}