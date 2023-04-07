package br.santosfyuri.service;

import br.santosfyuri.tdd.Passageiro;
import br.santosfyuri.tdd.TipoPassageiro;
import br.santosfyuri.tdd.Voo;
import br.santosfyuri.tdd.service.PrecoPassagemService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrecoPassagemServiceTest {

    PrecoPassagemService precoPassagemService;

    @Before
    public void deveCriarPrecoPassagemService() {
        precoPassagemService = new PrecoPassagemService();
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() {
        final Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
        final Voo voo = new Voo("São Paulo", "Rio Grande do Sul", 150.0);
        final double valor = precoPassagemService.calcular(passageiro, voo);
        assertEquals(135.0, valor, 0.0001);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_ComValorAcimaDoLimite() {
        final Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
        final Voo voo = new Voo("São Paulo", "Rio Grande do Sul", 600.0);
        final double valor = precoPassagemService.calcular(passageiro, voo);
        assertEquals(510.0, valor, 0.0001);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAbaixoDoLimite() {
        final Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
        final Voo voo = new Voo("São Paulo", "Rio Grande do Sul", 100.0);
        final double valor = precoPassagemService.calcular(passageiro, voo);
        assertEquals(94.0, valor, 0.0001);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAcimaDoLimite() {
        final Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
        final Voo voo = new Voo("São Paulo", "Rio Grande do Sul", 800.0);
        final double valor = precoPassagemService.calcular(passageiro, voo);
        assertEquals(720.0, valor, 0.0001);
    }
}
