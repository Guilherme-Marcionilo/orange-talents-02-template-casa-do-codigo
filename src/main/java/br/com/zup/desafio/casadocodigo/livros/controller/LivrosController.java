package br.com.zup.desafio.casadocodigo.livros.controller;

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

import br.com.zup.desafio.casadocodigo.livros.NovoLivroRequest;
import br.com.zup.desafio.casadocodigo.livros.model.Livros;
import br.com.zup.desafio.casadocodigo.livros.repository.LivrosRepository;

@RestController
@RequestMapping ("/livros")
public class LivrosController {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@GetMapping
	public ResponseEntity<List<Livros>> getAll(){
		return ResponseEntity.ok(livrosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livros> getById(@PathVariable Long id){
		return livrosRepository.findById(id)
				.map(resp-> ResponseEntity.ok(resp))
						.orElse(ResponseEntity.notFound().build());
	}

    @PostMapping
    @Transactional
    public String criar(@RequestBody @Valid NovoLivroRequest request) {
        Livros livro = request.toModel(em);

        em.persist(livro);

        return livro.toString();

    }
}
