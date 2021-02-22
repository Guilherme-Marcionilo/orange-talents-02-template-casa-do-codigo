package br.com.zup.desafio.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zup.desafio.casadocodigo.compartilhado.UniqueValue;

public class NovaCategoriaRequest {
	

	@NotBlank 
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	@Deprecated
	public NovaCategoriaRequest () {}
	
	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}



	public Categoria toModel() {
		return new Categoria(this.nome);
	}



	public String getNome() {
		return nome;
	}
	
	
	
}
