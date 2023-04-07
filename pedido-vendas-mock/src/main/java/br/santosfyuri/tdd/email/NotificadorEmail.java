package br.santosfyuri.tdd.email;

import br.santosfyuri.tdd.model.Pedido;
import br.santosfyuri.tdd.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido {

    @Override
    public void executar(Pedido pedido) {
        System.out.println("Enviando o e-mail...");
    }

}
