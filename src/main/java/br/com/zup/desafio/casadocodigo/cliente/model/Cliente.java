package br.com.zup.desafio.casadocodigo.cliente.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zup.desafio.casadocodigo.cliente.validacao.CPFouCNPJ;
import br.com.zup.desafio.casadocodigo.paisestado.model.Estado;
import br.com.zup.desafio.casadocodigo.paisestado.model.Pais;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CPFouCNPJ
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

    @Deprecated
    public Cliente() {}
    
    public Cliente(@Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
                   @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais,
                   @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    //RETIRAR ESTE MÉTODO, FOI APENAS PARA TESTE!
    public void setEstado(@Valid Estado estado) {
        this.estado = estado;
    }

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", pais=" + pais + ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}


	
	
	
}
