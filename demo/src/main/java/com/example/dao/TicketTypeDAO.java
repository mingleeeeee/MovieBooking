package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Ticket_type;

public interface TicketTypeDAO extends CrudRepository<Ticket_type, Long>{

}