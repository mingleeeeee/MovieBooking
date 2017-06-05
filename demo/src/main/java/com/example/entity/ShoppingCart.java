package com.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class ShoppingCart implements Serializable{
  /**
  * 
  */
 private static final long serialVersionUID = -5494311567944263493L;
 private List<Product> cart = new ArrayList<Product>();

 public Iterable<Product> getCart(){
   return cart;
 }
 public void add(Product product){
  cart.add(product);
 }
 public void cleanup(){
  cart = new ArrayList<Product>();
 }
 
}