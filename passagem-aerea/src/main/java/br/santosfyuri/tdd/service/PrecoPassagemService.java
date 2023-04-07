package br.santosfyuri.tdd.service;

import br.santosfyuri.tdd.Passageiro;
import br.santosfyuri.tdd.Voo;

public class PrecoPassagemService {
    public double calcular(Passageiro passageiro, Voo voo) {
        return passageiro.getTipo()
                .getCalculadora()
                .calcular(voo);
    }
}
