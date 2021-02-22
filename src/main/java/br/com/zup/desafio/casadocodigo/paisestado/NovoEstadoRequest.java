package br.com.zup.desafio.casadocodigo.paisestado;

import javax.persistence.EntityManager;

import br.com.zup.desafio.casadocodigo.compartilhado.ExistsId;
import br.com.zup.desafio.casadocodigo.compartilhado.UniqueValue;

public class NovoEstadoRequest {
	

	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	
	@Deprecated
	public NovoEstadoRequest() {}

	

	public NovoEstadoRequest(String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}


	public Estado toModel(EntityManager em) {
		return new Estado(nome, em.find(Pais.class, idPais));
	}



	public String getNome() {
		return nome;
	}



	public Long getIdPais() {
		return idPais;
	}
	
	
	
	
	

}
