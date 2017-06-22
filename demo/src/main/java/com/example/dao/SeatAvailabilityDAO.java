package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.entity.SeatAvailability;
import com.example.entity.Show;

public interface SeatAvailabilityDAO extends CrudRepository<SeatAvailability, Long>{
	public List<SeatAvailability> findByShow(Show show);
}