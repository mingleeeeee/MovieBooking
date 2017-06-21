package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.MovieCategory;

public interface MovieCategoryDAO extends CrudRepository<MovieCategory, Long>{

}