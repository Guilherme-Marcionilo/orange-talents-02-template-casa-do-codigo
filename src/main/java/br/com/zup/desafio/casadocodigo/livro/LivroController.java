package br.com.zup.desafio.CasaDoCodigo.livro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private LivroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Livro>> listar(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> getById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp-> ResponseEntity.ok(resp))
						.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoLivroRequest request) {

		Livro livro = request.toModel(em);
		
		em.persist(livro);
		
		return livro.toString();
		
		//throw new MinhaExcecao("O erro tá aqui!");
	}
}
