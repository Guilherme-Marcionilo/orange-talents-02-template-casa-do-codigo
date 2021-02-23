package br.com.zup.desafio.casadocodigo.livros.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.desafio.casadocodigo.autor.model.Autor;
import br.com.zup.desafio.casadocodigo.categoria.model.Categoria;

@Entity
@Table(name = "livros")
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer paginas;

    @NotNull
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @NotNull
    @ManyToOne
    private Categoria idCategoria;

    @NotNull
    @ManyToOne
    private Autor idAutor;

    @Deprecated
    public Livros() {}
    
    public Livros(@NotBlank String titulo,
                 @NotBlank String resumo,
                 @NotBlank String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer paginas,
                 @NotBlank String isbn,
                 @NotNull LocalDate dataLancamento,
                 @NotNull @Valid Categoria idCategoria,
                 @NotNull @Valid Autor idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    
    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", paginas=" + paginas +
                ", isbn=" + isbn +
                ", dataLancamento=" + dataLancamento +
                ", categoria=" + idCategoria +
                ", autor=" + idAutor +
                '}';
    }
    
    
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public String getSumario() {
		return sumario;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public Integer getPaginas() {
		return paginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public Categoria getIdCategoria() {
		return idCategoria;
	}
	public Autor getIdAutor() {
		return idAutor;
	}
    
}