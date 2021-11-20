package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;

public class Analisis {

    EstrategiaAnalisis estrategiaGrandesCaidas;

    EstrategiaAnalisis estrategiaAnalisis;


    public Analisis(){
        estrategiaGrandesCaidas = new EstrategiaGrandesCaidas(this);
        this.estrategiaAnalisis =estrategiaGrandesCaidas;
    }

    public boolean analizarCriptomoneda(Criptomoneda criptomoneda){
        return estrategiaAnalisis.analizarCriptomoneda(criptomoneda);
    }
}
