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
 private List<Order> cart = new ArrayList<Order>();

 public List<Order> getCart(){
   return cart;
 }
 public void add(Order order){
  cart.add(order);
 }
 public void cleanup(){
  cart = new ArrayList<Order>();
 }
public void delete(int i) {
	cart.remove(i) ;
	
}
 
}