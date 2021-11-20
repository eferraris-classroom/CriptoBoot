package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.requests.CriptoSeguidaRequest;

import java.util.List;

public interface CriptoSeguidaService {
    List<CriptoSeguida> getCriptosSeguidas(int idUser);

    CriptoSeguida agregarCriptoSeguida(CriptoSeguidaRequest criptoSeguidaRequest);

    void quitarCriptoSeguida(int idCriptoSeguida);
}
