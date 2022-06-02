package br.com.pontocom.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.pontocom.mvc.mudi.model.Pedido;
import br.com.pontocom.mvc.mudi.model.StatusPedido;

public class PedidoDto {

	@NotBlank
	private String nomeProduto;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String imagemProduto;
	
	private String descricao;
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getImagemProduto() {
		return imagemProduto;
	}
	public void setImagemProduto(String imagemProduto) {
		this.imagemProduto = imagemProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(imagemProduto);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
	
	
	

}
