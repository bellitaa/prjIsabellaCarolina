package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livros;
import com.example.demo.services.LivrosService;

@RestController
@RequestMapping("/Livros")
public class LivrosController {
		
	private final LivrosService livrosService;

	@Autowired
	public LivrosController(LivrosService livrosService) {
		this.livrosService = livrosService;
	}

	@PostMapping("/criar")
	public Livros criarLivros(@RequestBody Livros livros) {
		return livrosService.salvarLivros(livros);
	}

	@GetMapping
	public List<Livros> consultaTodos() {
		return livrosService.consultarTodosLivros();
	}

	@GetMapping("/{id}")
	public Livros consultarPorId(@PathVariable Long id) {
		return livrosService.consultarLivrosPorId(id);
	}
}