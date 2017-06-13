package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Seat;

public interface SeatDAO extends CrudRepository<Seat, Long>{

}