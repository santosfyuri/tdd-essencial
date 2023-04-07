package br.santosfyuri.tdd;

import br.santosfyuri.tdd.service.CalculadoraPrecoPassagem;
import br.santosfyuri.tdd.service.PrecoPassagemGold;
import br.santosfyuri.tdd.service.PrecoPassagemSilver;

public enum TipoPassageiro {

    GOLD(new PrecoPassagemGold()),
    SILVER(new PrecoPassagemSilver());

    private final CalculadoraPrecoPassagem calculadoraPrecoPassagem;

    TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
        this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
    }

    public CalculadoraPrecoPassagem getCalculadora() {
        return this.calculadoraPrecoPassagem;
    }
}
