package br.com.zup.desafio.casadocodigo.detalheLivro;

import br.com.zup.desafio.casadocodigo.autor.Autor;

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
