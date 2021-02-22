package br.com.zup.desafio.casadocodigo.livros;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.desafio.casadocodigo.autor.Autor;
import br.com.zup.desafio.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    public Livros(@NotBlank String titulo,
                 @NotBlank String resumo,
                 @NotBlank String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer paginas,
                 @NotBlank String isbn,
                 @NotNull LocalDate dataLancamento,
                 @NotNull Categoria idCategoria,
                 @NotNull Autor idAutor) {
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
    @Deprecated
    public Livros() {
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
}