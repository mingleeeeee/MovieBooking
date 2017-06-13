package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Movie;

public interface MovieDAO extends CrudRepository<Movie, Long>{

}