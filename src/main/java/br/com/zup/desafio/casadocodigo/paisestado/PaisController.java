package br.com.zup.desafio.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
