package br.santosfyuri.tdd.service;

import br.santosfyuri.tdd.model.Pedido;
import br.santosfyuri.tdd.model.StatusPedido;
import br.santosfyuri.tdd.repository.Pedidos;

import java.util.List;

public class PedidoService {

    private final List<AcaoLancamentoPedido> acoes;
    private final Pedidos pedidos;

    public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {
        this.acoes = acoes;
        this.pedidos = pedidos;
    }

    public double lancar(Pedido pedido) {
        final double imposto = pedido.getValor() * 0.1;
        acoes.forEach(a -> a.executar(pedido));
        return imposto;
    }

    public Pedido pagar(Long codigoPedido) {
        Pedido pedido = pedidos.buscarPeloCodigo(codigoPedido);
        if (!StatusPedido.PENDENTE.equals(pedido.getStatus())) {
            throw new StatusPedidoInvalidoException();
        }
        pedido.setStatus(StatusPedido.PAGO);
        return pedido;
    }
}
