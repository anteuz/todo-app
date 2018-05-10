package com.darkchitect.springboot.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darkchitect.springboot.web.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	List<Todo> findByUsername(String username);
}
