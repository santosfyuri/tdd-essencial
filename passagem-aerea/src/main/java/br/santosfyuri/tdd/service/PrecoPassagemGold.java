package br.santosfyuri.tdd.service;

import br.santosfyuri.tdd.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {
    @Override
    public double calcular(Voo voo) {
        return voo.getPreco() > 500.0
                ? calcularValorAcimaDoLimite(voo.getPreco())
                : calcularValorAbaixoDoLimite(voo.getPreco());
    }

    private double calcularValorAcimaDoLimite(double preco) {
        return preco * 0.85;
    }

    private double calcularValorAbaixoDoLimite(double preco) {
        return preco * 0.90;
    }
}
