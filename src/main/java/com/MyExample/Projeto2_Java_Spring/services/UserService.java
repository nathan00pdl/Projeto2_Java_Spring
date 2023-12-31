package com.MyExample.Projeto2_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto2_Java_Spring.entities.User;
import com.MyExample.Projeto2_Java_Spring.repositories.UserRepository;
import com.MyExample.Projeto2_Java_Spring.services.exceptions.DatabaseException;
import com.MyExample.Projeto2_Java_Spring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Inserindo (INSERT) usuários no banco de dados H2
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//Deletando (DELETE) usuários do banco de dados H2
	public void delete(Long id) {
		try{
			repository.deleteById(id);;
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//Atualizando (UPDATE) usuários no banco de dados H2
	public User update(Long id, User obj) {
		try{
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private	void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
