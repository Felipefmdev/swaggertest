package com.example.swaggertest.repository;

import com.example.swaggertest.entity.InstrutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<InstrutorEntity, Integer> { 
	
}
