package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Parametro;
import ar.edu.undef.fie.criptoboot.repositories.ParametroRepository;
import ar.edu.undef.fie.criptoboot.requests.ParametroRequest;
import org.springframework.stereotype.Service;

@Service
public class ParametroServiceImpl implements ParametroService{

    private final ParametroRepository parametroRepository;

    public ParametroServiceImpl(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }


    @Override
    public Parametro getParametros(int idUser) {
        return parametroRepository.findByUsuarioId(idUser);
    }

    @Override
    public Parametro modificarParametros(Parametro parametro) {
        return parametroRepository.save(parametro);
    }
}
