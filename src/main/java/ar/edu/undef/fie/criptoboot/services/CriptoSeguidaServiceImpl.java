package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.entities.Usuario;
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
    public void criptoSeguidaInicial(Usuario usuario) {
        CriptoSeguida criptoSeguida=new CriptoSeguida();
        criptoSeguida.setUsuario(usuario);
        criptoSeguida.setId_cripto("bitcoin");
        criptoSeguidaRepository.save(criptoSeguida);
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
