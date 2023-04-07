package br.santosfyuri.tdd.desconto;

public class Calculadora2aFaixaDesconto extends CalculadoraFaixaDesconto {

    public Calculadora2aFaixaDesconto(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    protected double calcular(double valorTotal) {
        if (valorTotal > 800.0 && valorTotal <= 1000.0) {
            return valorTotal * 0.06;
        }
        return -1;
    }
}
