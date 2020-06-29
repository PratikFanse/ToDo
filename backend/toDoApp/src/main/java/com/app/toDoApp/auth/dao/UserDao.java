package com.app.toDoApp.auth.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.toDoApp.auth.model.DAOUser;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UserDao extends CrudRepository<DAOUser, Integer> {

	DAOUser findByUsername(String username);

}