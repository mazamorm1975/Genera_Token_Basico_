package com.tokens.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tokens.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

   DAOUser findByusername(String username);
}
