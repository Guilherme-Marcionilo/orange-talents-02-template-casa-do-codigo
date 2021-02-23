package br.com.zup.desafio.casadocodigo.autor.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casadocodigo.autor.NovoAutorRequest;
import br.com.zup.desafio.casadocodigo.autor.model.Autor;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<Autor> cadastrar(@RequestBody @Valid NovoAutorRequest request) {
		
		Autor autor = request.toModel();
		em.persist(autor);

		return ResponseEntity.ok(autor);

	}

}
