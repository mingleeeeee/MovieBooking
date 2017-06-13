package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Ticket;

public interface TicketDAO extends CrudRepository<Ticket, Long>{

}