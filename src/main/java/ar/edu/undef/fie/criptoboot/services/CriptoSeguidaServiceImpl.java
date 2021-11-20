package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.repositories.CriptoSeguidaRepository;
import ar.edu.undef.fie.criptoboot.requests.CriptoSeguidaRequest;
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
        return criptoSeguidaRepository.findByUsuarioId(idUser);
    }

    @Override
    public CriptoSeguida agregarCriptoSeguida(CriptoSeguidaRequest criptoSeguidaRequest) {
        return criptoSeguidaRepository.save( criptoSeguidaRequest.construct());
    }

    @Override
    public void quitarCriptoSeguida(int idCriptoSeguida) {
        criptoSeguidaRepository.deleteById(idCriptoSeguida);
    }
}
