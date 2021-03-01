package br.com.zup.desafio.CasaDoCodigo.autor.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.CasaDoCodigo.autor.NovoAutorRequest;
import br.com.zup.desafio.CasaDoCodigo.autor.model.Autor;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoAutorRequest autorRequest){
		Autor autor = autorRequest.toModel();
		em.persist(autor);
		
		return autor.toString();
	}
	
	
}
