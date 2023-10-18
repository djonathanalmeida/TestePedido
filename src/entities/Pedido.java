package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private Date momento;
	private PedidoStatus status;
	private Cliente cliente;
	private List<PedidoItem> itens = new ArrayList<PedidoItem>(); // ou somente ArrayList<>();

	private static SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Pedido() {

	}

	public Pedido(Date momento, PedidoStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addItem(PedidoItem item) {
		itens.add(item);
	}

	public void removeItem(Pedido item) {
		itens.remove(item);
	}

	public Double total() {
		Double soma = 0.0;
		for (PedidoItem x : itens) {
			soma += x.subTotal();
		}

		return soma;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Data do Pedido: ");
		sb.append(s.format(momento) + "\n");
		sb.append("Status do Pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do Pedido:\n");
		
		for (PedidoItem item : itens) {
			sb.append(item + "\n");
		}
		
		sb.append("Preço total: $");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}

}
