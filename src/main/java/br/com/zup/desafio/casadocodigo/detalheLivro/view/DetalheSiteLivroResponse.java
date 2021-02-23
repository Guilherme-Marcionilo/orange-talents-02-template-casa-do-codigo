package br.com.zup.desafio.casadocodigo.detalheLivro.view;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.desafio.casadocodigo.livros.model.Livros;

public class DetalheSiteLivroResponse {

	private String titulo;
	private DetalheSiteAutorResponse autor;
	private String isbn;
	private int paginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String dataLancamento;
	
	
	public DetalheSiteLivroResponse(Livros livroBuscado) {

		titulo = livroBuscado.getTitulo();
		autor = new DetalheSiteAutorResponse(livroBuscado.getIdAutor());
		isbn = livroBuscado.getIsbn();
		paginas = livroBuscado.getPaginas();
		preco = livroBuscado.getPreco();
		resumo = livroBuscado.getResumo();
		sumario = livroBuscado.getSumario();
		dataLancamento = livroBuscado.getDataLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
	}


	public String getTitulo() {
		return titulo;
	}


	public DetalheSiteAutorResponse getAutor() {
		return autor;
	}


	public String getIsbn() {
		return isbn;
	}


	public int getPaginas() {
		return paginas;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public String getDataLancamento() {
		return dataLancamento;
	}


	
	
}
