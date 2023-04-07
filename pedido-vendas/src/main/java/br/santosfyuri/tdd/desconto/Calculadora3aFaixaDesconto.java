package br.santosfyuri.tdd.desconto;

public class Calculadora3aFaixaDesconto extends CalculadoraFaixaDesconto {

    public Calculadora3aFaixaDesconto(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    protected double calcular(double valorTotal) {
        if (valorTotal > 1000.0) {
            return valorTotal * 0.08;
        }
        return -1;
    }
}
