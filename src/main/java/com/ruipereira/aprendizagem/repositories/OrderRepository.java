package com.ruipereira.aprendizagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruipereira.aprendizagem.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>
{
	
	

}
