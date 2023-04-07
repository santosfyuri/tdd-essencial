package br.santosfyuri.tdd.model.builder;

import br.santosfyuri.tdd.model.Cliente;
import br.santosfyuri.tdd.model.Pedido;
import br.santosfyuri.tdd.model.StatusPedido;

public class PedidoBuilder {

	private Pedido instancia;
	
	public PedidoBuilder() {
		instancia = new Pedido();
	}
	
	public Pedido construir() {
		return instancia;
	}
	
	public PedidoBuilder valor(double valor) {
		instancia.setValor(valor);
		return this;
	}
	
	public PedidoBuilder cliente(String nome, String email, String telefone) {
		Cliente cliente = new Cliente(nome, email, telefone);
		instancia.setCliente(cliente);
		return this;
	}

	public PedidoBuilder status(StatusPedido statusPedido) {
		instancia.setStatus(statusPedido);
		return this;
	}
	
}
