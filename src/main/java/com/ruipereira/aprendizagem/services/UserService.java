package com.ruipereira.aprendizagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruipereira.aprendizagem.entities.Utilizador;
import com.ruipereira.aprendizagem.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	

	public List<Utilizador> findAll()
	{
		return repository.findAll();
	}
	
	public Utilizador findById(Long id)
	{
		Optional<Utilizador> obj = repository.findById(id);
		return obj.get();
	}
	
	public Utilizador insert(Utilizador obj)
	{
		return repository.save(obj);
	}

}
