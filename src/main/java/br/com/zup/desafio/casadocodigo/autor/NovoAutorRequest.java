package br.com.zup.desafio.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.desafio.casadocodigo.autor.model.Autor;
import br.com.zup.desafio.casadocodigo.compartilhado.UniqueValue;

public class NovoAutorRequest {
	@NotBlank
	private String nome;

	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;
	
	@Deprecated
	public NovoAutorRequest() {}

	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {

		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return this.email;
	}

	public String getDescricao() {
		return descricao;
	}
}