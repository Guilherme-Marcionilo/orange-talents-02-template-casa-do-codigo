package br.com.zup.desafio.CasaDoCodigo.paisestado;

import javax.validation.constraints.NotBlank;

import br.com.zup.desafio.CasaDoCodigo.compartilhado.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "O nome deve ser único!")
	private String nome;

	@Deprecated
	public NovoPaisRequest() {}
	
	public NovoPaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
}
