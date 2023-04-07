package br.santosfyuri.tdd.sms;

import br.santosfyuri.tdd.model.Pedido;
import br.santosfyuri.tdd.service.AcaoLancamentoPedido;

public class NotificadorSms implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviando o sms...");
	}
	
}
