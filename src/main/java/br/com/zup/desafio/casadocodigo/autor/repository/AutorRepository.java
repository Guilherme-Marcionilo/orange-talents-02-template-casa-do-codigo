package br.com.zup.desafio.casadocodigo.autor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.desafio.casadocodigo.autor.model.Autor;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);
}