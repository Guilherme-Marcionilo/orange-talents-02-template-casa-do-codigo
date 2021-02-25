package br.com.zup.desafio.CasaDoCodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zup.desafio.CasaDoCodigo.compartilhado.UniqueValue;

public class NovaCategoriaRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome da categoria deve ser único!")
	private String nome;

	@Deprecated
	public NovaCategoriaRequest() {}
	
	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

		
	

}
