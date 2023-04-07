package br.santosfyuri.tdd.repository;

import br.santosfyuri.tdd.model.Pedido;
import br.santosfyuri.tdd.service.AcaoLancamentoPedido;

public class Pedidos implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Salvando no banco de dados...");
	}

	public Pedido buscarPeloCodigo(Long codigo) {
		return new Pedido();
	}
	
}
