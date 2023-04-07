package br.santosfyuri.tdd;

import br.santosfyuri.tdd.ItemPedido;
import br.santosfyuri.tdd.Pedido;
import br.santosfyuri.tdd.ResumoPedido;
import br.santosfyuri.tdd.desconto.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PedidoTest {

    private Pedido pedido;

    @Before
    public void deveCriarUmPedido() {
        CalculadoraFaixaDesconto calculadoraFaixaDesconto =
                new Calculadora3aFaixaDesconto(
                        new Calculadora2aFaixaDesconto(
                                new Calculadora1aFaixaDesconto(
                                        new SemDesconto(null))));
        pedido = new Pedido(calculadoraFaixaDesconto);
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() {
        assertResumoPedido(0.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
        assertResumoPedido(25.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaDoisItensSemDesconto() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
        pedido.adicionarItem(new ItemPedido("Pasta de dente", 7.0, 3));
        assertResumoPedido(30.0, 0.0);
    }

    @Test
    public void deveAplicarDescontona1aFaixa() {
        pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));
        assertResumoPedido(400.0, 16.0);
    }

    @Test
    public void deveAplicarDescontona2aFaixa() {
        pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
        assertResumoPedido(900.0, 54.0);
    }

    @Test
    public void deveAplicarDescontona3aFaixa() {
        pedido.adicionarItem(new ItemPedido("Creme", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Shampoo", 10.0, 30));
        pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
        assertResumoPedido(1200.0, 96.0);
    }

    private void assertResumoPedido(double valorTotal, double desconto) {
        ResumoPedido resumoPedido = pedido.resumo();
        assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
        assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
    }
}
