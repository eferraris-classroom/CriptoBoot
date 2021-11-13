package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.repositories.CriptoSeguidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriptoSeguidaServiceImpl implements CriptoSeguidaService{

    private final CriptoSeguidaRepository criptoSeguidaRepository;

    public CriptoSeguidaServiceImpl(CriptoSeguidaRepository criptoSeguidaRepository) {
        this.criptoSeguidaRepository = criptoSeguidaRepository;
    }

    @Override
    public List<CriptoSeguida> getCriptosSeguidas(int idUser) {
        //Cómo logro buscar todos los valores para un usuario?
        return null;
    }

    @Override
    public void agregarCriptoSeguida(int userId, String symbol) {
        //Cómo agrego un elemento segun el id del usuario (clave foranea)?
    }

    @Override
    public void quitarCriptoSeguida(int userId, String symbol) {
        //Cómo quito un elemento segun el id del usuario (clave foranea)?
    }
}
