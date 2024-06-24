package com.ruipereira.aprendizagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruipereira.aprendizagem.entities.Utilizador;
import com.ruipereira.aprendizagem.repositories.UserRepository;
import com.ruipereira.aprendizagem.services.exceptions.DatabaseException;
import com.ruipereira.aprendizagem.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Utilizador insert(Utilizador obj)
	{
		return repository.save(obj);
	}
	
	public void delete(Long id)
	{
		try {
		 repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e)
		{
			throw new DatabaseException(e.getMessage());
		}
	}

	public Utilizador update(Long id, Utilizador obj)
	{
		Utilizador entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Utilizador entity, Utilizador obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
	
	

}
