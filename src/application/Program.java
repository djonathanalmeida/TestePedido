package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.Pedido;
import entities.PedidoItem;
import entities.PedidoStatus;
import entities.Produto;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Informe os dados do cliente:");
		
		System.out.println("Nome: ");
		String nome = sc.next();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Data de Nascimento: ");
		Date dataNascimento = s.parse(sc.next());
		
		Cliente cli = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Informe os dados do pedido:");
		
		System.out.println("Qual o status do pedido?");
		PedidoStatus status = PedidoStatus.valueOf(sc.next());
		
		Pedido ped = new Pedido(new Date(), status, cli);
		
		System.out.println("Quantos itens o pedido irá ter?");
		Integer cont = sc.nextInt();
		
		for(Integer x=1; x <= cont; x++) {
			System.out.println("Pedido #" + x);
			System.out.println("Nome do Produto:");
			String nomeProd = sc.next();
			System.out.println("Preço do Produto:");
			Double precoProd = sc.nextDouble();
			System.out.println("Quantidade do Produto:");
			Integer qtdeProd = sc.nextInt();
			
			Produto prod = new Produto(nomeProd, precoProd);
			
			PedidoItem item = new PedidoItem(qtdeProd, precoProd, prod);
			
			ped.addItem(item);
		}
		
		System.out.println(ped);
		
		sc.close();
		
	}

}
