package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Livros;
import com.example.demo.repositories.LivrosRepository;

@Service
public class LivrosService {
	
	private final LivrosRepository livrosRepository;
	
	
	@Autowired
	public LivrosService(LivrosRepository livrosRepository) {
	     this.livrosRepository = livrosRepository;
	}
	
	public Livros salvarLivros(Livros livros) {
		return livrosRepository.save(livros);
		
	}
	
	public Livros consultarLivrosPorId(Long id) {
		return livrosRepository.findById(id).orElse(null);
	}
	
	public List<Livros> consultarTodosLivros(){
		return livrosRepository.findAll();
	}
	
	public void excluirLivros(Long id) {
		livrosRepository.deleteById(id);
	}
	public Livros atualizarCliente(Long id, Livros livrosAtualizado) {
		Optional<Livros> livrosExistente = livrosRepository.findById(id);
		if(livrosExistente.isPresent()) {
			Livros livros = livrosExistente.get();
			livros.setIsbn(livrosAtualizado.getIsbn());
			livros.setTitulo(livrosAtualizado.getTitulo());
			return livrosRepository.save(livros);
		}
		else
		{
			return null;
		}
	}
}