package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Member;


public interface MemberDAO extends CrudRepository<Member, Long>{

}