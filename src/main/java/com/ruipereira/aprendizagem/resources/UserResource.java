package com.ruipereira.aprendizagem.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruipereira.aprendizagem.entities.Utilizador;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
     
	 @GetMapping
	 public ResponseEntity<Utilizador> findAll()
	 {
		 Utilizador u = new Utilizador(1L,"Maria","maria@gmail.com","9999999","12345");
		 return ResponseEntity.ok().body(u);
	 }
}
