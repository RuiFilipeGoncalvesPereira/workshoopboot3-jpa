package com.ruipereira.aprendizagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruipereira.aprendizagem.entities.Utilizador;

public interface UserRepository extends JpaRepository<Utilizador,Long>
{
	
	

}
