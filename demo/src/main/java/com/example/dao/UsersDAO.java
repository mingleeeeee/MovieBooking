package com.example.dao;

import org.springframework.data.repository.CrudRepository;


import com.example.entity.Users;

public interface UsersDAO extends CrudRepository<Users, String>{

}