package br.com.zup.desafio.casadocodigo.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.desafio.casadocodigo.livros.model.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{

	
}
