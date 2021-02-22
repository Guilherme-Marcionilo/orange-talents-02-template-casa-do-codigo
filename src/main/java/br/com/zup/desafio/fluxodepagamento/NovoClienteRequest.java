package br.com.zup.desafio.fluxodepagamento;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zup.desafio.casadocodigo.compartilhado.UniqueValue;
import br.com.zup.desafio.casadocodigo.paisestado.Estado;
import br.com.zup.desafio.casadocodigo.paisestado.Pais;

public class NovoClienteRequest {
	
	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@CPFouCNPJ
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;
    
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	public Cliente toModel(EntityManager em) {
		return null;
	}
	
	
	
	
}
