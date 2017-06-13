package com.example.dao;
import org.springframework.data.repository.CrudRepository;

import com.example.entity.Transaction;

public interface TransactionDAO extends CrudRepository<Transaction, Long>{

}