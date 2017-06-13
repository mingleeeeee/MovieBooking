package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Show;

public interface ShowDAO extends CrudRepository<Show, Long>{

}