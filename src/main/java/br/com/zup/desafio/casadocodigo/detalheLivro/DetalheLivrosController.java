package br.com.zup.desafio.casadocodigo.detalheLivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casadocodigo.livros.Livros;

@RestController
public class DetalheLivrosController {

	@PersistenceContext
	private EntityManager em;
	
	
	@GetMapping(value = "/produtos/{id}")
	public ResponseEntity<?> detalhar(@PathVariable("id") Long id) {
		
		// O FIND RETORNA NULO, ENTÃO TEMOS QUE VERIFICAR
		Livros livroBuscado = em.find(Livros.class, id);
		
		if(livroBuscado == null) {
			return ResponseEntity.notFound().build();
		}
		
		
		DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
		return ResponseEntity.ok(detalheSiteLivroResponse);
	}
	
	
	
	
	
	
}
