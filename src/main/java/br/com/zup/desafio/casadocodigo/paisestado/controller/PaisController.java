package br.com.zup.desafio.casadocodigo.paisestado.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casadocodigo.paisestado.NovoPaisRequest;
import br.com.zup.desafio.casadocodigo.paisestado.model.Pais;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoPaisRequest request){
		Pais novoPais = new Pais(request.getNome());
		em.persist(novoPais);
		
		return novoPais.toString();
	}
}
