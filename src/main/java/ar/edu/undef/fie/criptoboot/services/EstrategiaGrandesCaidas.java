package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;

public class EstrategiaGrandesCaidas implements EstrategiaAnalisis{

    Analisis analisis;

    public EstrategiaGrandesCaidas(Analisis analisis) {
        this.analisis=analisis;
    }

    public boolean analizarCriptomoneda(Criptomoneda criptomoneda){

        //EL ANALISIS SE HACE EN BASE A UNA RUTINA RANDOM PARA QUE SE PUEDAN REALIZAR OPERACIONES
        int random_int = (int)Math.floor(Math.random()*(10-1+1)+1);
        if (random_int%2==0){
            System.out.println("No es recomendable comprar " + criptomoneda.getSymbol() + ".");
            return false;
        }else {
            return true;
        }
    }
}
