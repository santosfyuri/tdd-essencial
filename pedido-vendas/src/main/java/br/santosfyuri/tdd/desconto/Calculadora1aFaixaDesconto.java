package br.santosfyuri.tdd.desconto;

public class Calculadora1aFaixaDesconto extends CalculadoraFaixaDesconto {

    public Calculadora1aFaixaDesconto(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    protected double calcular(double valorTotal) {
        if (valorTotal > 300.0 && valorTotal <= 800.0) {
            return valorTotal * 0.04;
        }
        return -1;
    }
}
