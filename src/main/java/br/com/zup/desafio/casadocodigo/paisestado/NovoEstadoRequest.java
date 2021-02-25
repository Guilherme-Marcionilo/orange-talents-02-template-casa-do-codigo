package br.com.zup.desafio.CasaDoCodigo.paisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zup.desafio.CasaDoCodigo.compartilhado.ExistsId;
import br.com.zup.desafio.CasaDoCodigo.paisestado.validacao.UniqueEstadoPais;


@UniqueEstadoPais(domainClass = Estado.class,fieldName1 = "nome",fieldName2 = "idPais")
public class NovoEstadoRequest {

	@NotBlank
	private String nome;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "Este Pais não existe!")
	private Long idPais;

	@Deprecated
	public NovoEstadoRequest() {
	}

	public NovoEstadoRequest(String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

    public Estado toModel(EntityManager em){
        Pais pais = em.find(Pais.class,this.idPais);
        return new Estado(this.nome,pais);
    }

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}


}
