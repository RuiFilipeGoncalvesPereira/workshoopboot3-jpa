package com.ruipereira.aprendizagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruipereira.aprendizagem.entities.OrderItem;
import com.ruipereira.aprendizagem.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>
{
	
	

}
