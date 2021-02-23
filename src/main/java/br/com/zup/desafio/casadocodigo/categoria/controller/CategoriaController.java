package br.com.zup.desafio.casadocodigo.categoria.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casadocodigo.categoria.NovaCategoriaRequest;
import br.com.zup.desafio.casadocodigo.categoria.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid NovaCategoriaRequest request) {
		
		Categoria categoria = request.toModel();
		em.persist(categoria);
		
		return ResponseEntity.ok(categoria);
	}
	
}
