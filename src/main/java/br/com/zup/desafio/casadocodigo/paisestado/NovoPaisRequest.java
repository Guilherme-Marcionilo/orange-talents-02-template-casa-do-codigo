package br.com.zup.desafio.casadocodigo.paisestado;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import br.com.zup.desafio.casadocodigo.compartilhado.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	@Deprecated
	public NovoPaisRequest() {}

	public NovoPaisRequest(@NotBlank @Valid String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}


	
	
	
	
}
