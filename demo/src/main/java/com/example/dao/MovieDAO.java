package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Movie;
import com.example.entity.MovieCategory;

public interface MovieDAO extends CrudRepository<Movie, Long>{
	public Iterable<Movie> findByMovieCategory(MovieCategory category);
}