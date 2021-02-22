package br.com.zup.desafio.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {

	@PersistenceContext
	private EntityManager em;
	
	@PostMapping(value = "/estados")
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoEstadoRequest request){
		Estado novoEstado = request.toModel(em);
		em.persist(novoEstado);
		return novoEstado.toString();
	}
	
	
}
