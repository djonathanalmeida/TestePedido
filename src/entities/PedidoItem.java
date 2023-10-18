package entities;

public class PedidoItem {
	
	private Integer quantidade;
	private Double preco;
	private Produto produto;
	
	public PedidoItem() {
		
	}

	public PedidoItem(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Double subTotal() {
		return quantidade * preco;
	}
	
	@Override
	public String toString() {
		return getProduto().getDescricao()
				+ ", $"
				+ String.format("%.2f", preco)
				+ ", Quantity: "
				+ quantidade
				+ ", Subtotal: $"
				+ String.format("%.2f", subTotal());
	}

}
