package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
@RunWith(Parameterized.class)
class CriptomonedaServiceTest {

    private final CriptomonedaService criptomonedaService;

    CriptomonedaServiceTest(CriptomonedaService criptomonedaService) {
        this.criptomonedaService = criptomonedaService;
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Dado: un objeto MarioBros con estado marito, Cuando: toca un hongo, Entonces: su estado pasa a ser superMario ")
    void getCriptomonedas() {
        /* Given */
        List<Criptomoneda> lista;
        Criptomoneda cripto = new Criptomoneda();
        //When
        lista= criptomonedaService.getCriptomonedas();
        //Then
        Assertions.assertEquals(lista.get(0).getClass(), cripto.getClass());
    }
}