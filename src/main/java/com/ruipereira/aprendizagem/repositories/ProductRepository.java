package com.ruipereira.aprendizagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruipereira.aprendizagem.entities.Category;
import com.ruipereira.aprendizagem.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>
{
	
	

}
