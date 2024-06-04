package com.ruipereira.aprendizagem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruipereira.aprendizagem.entities.Utilizador;
import com.ruipereira.aprendizagem.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
     
	 @GetMapping
	 public ResponseEntity<List<Utilizador>> findAll()
	 {
		 //Utilizador u = new Utilizador(1L,"Maria","maria@gmail.com","9999999","12345");
		 List<Utilizador> list = service.findAll();
		 return ResponseEntity.ok().body(list);
	 }
		 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<Utilizador> findById(@PathVariable Long id)
	 {
		 Utilizador obj = service.findById(id);
		 return ResponseEntity.ok().body(obj);
	 }
}
