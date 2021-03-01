package br.com.zup.desafio.CasaDoCodigo.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.desafio.CasaDoCodigo.livro.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
