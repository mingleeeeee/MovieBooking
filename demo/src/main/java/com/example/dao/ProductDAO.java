package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Product;

public interface ProductDAO extends CrudRepository<Product, Long>{

}