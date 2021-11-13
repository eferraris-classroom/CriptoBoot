package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;

import java.util.List;

public interface CriptomonedaService {
    List<Criptomoneda> getCriptomonedas(int userId);

    void cargarCripto(Criptomoneda criptomoneda);

    Criptomoneda getCriptomonedasPorId (String id);

}
