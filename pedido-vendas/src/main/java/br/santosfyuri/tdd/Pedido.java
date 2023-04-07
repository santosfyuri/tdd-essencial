package br.santosfyuri.tdd;

import br.santosfyuri.tdd.desconto.CalculadoraFaixaDesconto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private CalculadoraFaixaDesconto calculadoraFaixaDesconto;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
        this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        itens.add(itemPedido);
    }

    public ResumoPedido resumo() {
        double valorTotal = itens.stream().mapToDouble(i -> i.getValorUnitario() * i.getQuantidade()).sum();
        double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
        return new ResumoPedido(valorTotal, desconto);
    }
}
