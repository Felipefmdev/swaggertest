package com.example.swaggertest.repository;

import com.example.swaggertest.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<TurmaEntity, Integer> { 
	
}