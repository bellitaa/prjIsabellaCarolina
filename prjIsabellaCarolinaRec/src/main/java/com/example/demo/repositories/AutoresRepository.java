package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Autores;

public interface AutoresRepository extends JpaRepository<Autores, Long>{
	
}