package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;

import java.util.List;

public interface CriptoSeguidaService {
    List<CriptoSeguida> getCriptosSeguidas(int idUser);

    void agregarCriptoSeguida(int idUser, String symbol);

    void quitarCriptoSeguida(int idUser, String symbol);
}
