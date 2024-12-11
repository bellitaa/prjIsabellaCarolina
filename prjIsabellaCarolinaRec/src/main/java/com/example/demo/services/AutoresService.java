package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Autores;
import com.example.demo.repositories.AutoresRepository;

@Service
public class AutoresService {
	
	private final AutoresRepository autoresRepository;
	
	
	@Autowired
	public AutoresService(AutoresRepository autoresRepository) {
	     this.autoresRepository = autoresRepository;
	}
	
	public Autores salvarAutores(Autores autores) {
		return autoresRepository.save(autores);
		
	}
	
	public Autores consultarAutoresPorId(Long id) {
		return autoresRepository.findById(id).orElse(null);
	}
	
	public List<Autores> consultarTodosAutores(){
		return autoresRepository.findAll();
	}
	
	public void excluirAutores(Long id) {
		autoresRepository.deleteById(id);
	}
	public Autores atualizarAutores(Long id, Autores autoresAtualizado) {
		Optional<Autores> autoresExistente = autoresRepository.findById(id);
		if(autoresExistente.isPresent()) {
			Autores autores = autoresExistente.get();
			autores.setNome(autoresAtualizado.getNome());
			autores.setNacionalidade(autoresAtualizado.getNacionalidade());
			return autoresRepository.save(autores);
		}
		else
		{
			return null;
		}
	}
}