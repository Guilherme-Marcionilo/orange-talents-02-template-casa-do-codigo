package br.com.zup.desafio.fluxodepagamento;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid NovoClienteRequest request) {
		Cliente cliente = request.toModel(em);

		em.persist(cliente);

		return cliente.toString();

	}
}
