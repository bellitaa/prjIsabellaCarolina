package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Autores;
import com.example.demo.services.AutoresService;

@RestController
@RequestMapping("/Autores")
public class AutoresController {
		
	private final AutoresService autoresService;

	@Autowired
	public AutoresController(AutoresService autoresService) {
		this.autoresService = autoresService;
	}

	@PostMapping("/criar")
	public Autores criarAutores(@RequestBody Autores autores) {
		return autoresService.salvarAutores(autores);
	}

	@GetMapping
	public List<Autores> consultaTodos() {
		return autoresService.consultarTodosAutores();
	}

	@GetMapping("/{id}")
	public Autores consultarPorId(@PathVariable Long id) {
		return autoresService.consultarAutoresPorId(id);
	}
}