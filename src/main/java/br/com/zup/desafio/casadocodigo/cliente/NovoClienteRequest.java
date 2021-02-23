package br.com.zup.desafio.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.desafio.casadocodigo.cliente.model.Cliente;
import br.com.zup.desafio.casadocodigo.cliente.validacao.CPFouCNPJ;
import br.com.zup.desafio.casadocodigo.compartilhado.ExistsId;
import br.com.zup.desafio.casadocodigo.compartilhado.UniqueValue;
import br.com.zup.desafio.casadocodigo.paisestado.model.Estado;
import br.com.zup.desafio.casadocodigo.paisestado.model.Pais;

public class NovoClienteRequest {

    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
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
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Deprecated
    public NovoClienteRequest() {}
    
    
    public NovoClienteRequest(@Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                          @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                          @NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
                          @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(EntityManager em) {
        Pais pais = em.find(Pais.class, idPais);
        Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento,
                this.endereco, this.complemento, this.cidade, pais, this.telefone,
                this.cep);
        if (idEstado != null) {
            cliente.setEstado(em.find(Estado.class, idEstado));
        }
        return cliente;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }
    
    public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	@Override
    public String toString() {
        return "ClienteRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}