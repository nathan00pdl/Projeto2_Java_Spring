package com.MyExample.Projeto2_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto2_Java_Spring.entities.User;
import com.MyExample.Projeto2_Java_Spring.repositories.UserRepository;

@Service
public class UserService {

	//Declarando "Injeção de dependência"
	
	@Autowired  //Resolve a dependência e associa uma instância desse objeto ('UserRepository') à classe 'UserService' 
	private UserRepository repository;
	
	
	//Declarando endpoints
	
	//Retornando todos os usuários do banco de dados
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//Retornando usuários pelo id
	public User FindById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}