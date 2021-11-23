package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalisisTest {

    @Test
    @DisplayName("Dado: una criptomoneda a un objeto analisis, Cuando: se analiza la misma, Entonces: el resultado nunca es nullo ")
    public void testAnalisis(){
        //Given
        Analisis analisis=new Analisis();
        Criptomoneda criptomoneda = new Criptomoneda();
        //When
        Boolean resultado = analisis.analizarCriptomoneda(criptomoneda);
        //Then
        Assertions.assertNotNull(resultado);
    }


}