package com.ruipereira.aprendizagem.resources;

import java.net.URI;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 
	 @PostMapping
	 public ResponseEntity<Utilizador> insert(@RequestBody Utilizador obj)
	 {
		 obj = service.insert(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		 return ResponseEntity.created(uri).body(obj);
	 }
	 @DeleteMapping(value = "/{id}")
	 public ResponseEntity<Void> delete(@PathVariable Long id)
	 {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	 }
	 
	 @PutMapping(value = "/{id}")
	 public ResponseEntity<Utilizador> update(@PathVariable Long id, @RequestBody Utilizador obj)
	 {
		 obj = service.update(id, obj);
		 return ResponseEntity.ok().body(obj);
	 }
	 
}
