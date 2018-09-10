package com.lucasfernando.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasfernando.cursomc.domain.Categoria;
import com.lucasfernando.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> get() {		
		List<Categoria> lista = repository.findAll();
		return lista;
	}

	public Categoria get(int id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
