package br.com.zup.desafio.CasaDoCodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoEstadoRequest request){
		Estado novoEstado = request.toModel(em);
		em.persist(novoEstado);
		
		return novoEstado.toString();
	}
	
	
}
