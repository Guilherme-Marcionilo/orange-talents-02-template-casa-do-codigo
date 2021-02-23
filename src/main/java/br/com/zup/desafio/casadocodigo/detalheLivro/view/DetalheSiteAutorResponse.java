package br.com.zup.desafio.casadocodigo.detalheLivro.view;

import br.com.zup.desafio.casadocodigo.autor.model.Autor;

public class DetalheSiteAutorResponse{

	private String nome;
	private String descricao;
	
	public DetalheSiteAutorResponse(Autor idAutor) {
		nome = idAutor.getNome();
		descricao = idAutor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	
}
