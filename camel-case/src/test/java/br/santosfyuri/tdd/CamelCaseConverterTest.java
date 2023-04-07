package br.santosfyuri.tdd;

import br.santosfyuri.tdd.CamelCaseConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CamelCaseConverterTest {

    private CamelCaseConverter camelCase;

    @Before
    public void setup() {
        camelCase = new CamelCaseConverter();
    }

    @Test
    public void deveConverterNomeSimples() {
        assertEquals("Lionel", camelCase.converter("lionel"));
    }

    @Test
    public void deveConverterNomeSimplesMisturadoMaiusculoEMinusculo() {
        assertEquals("Lionel", camelCase.converter("LiOnEL"));
    }
}
