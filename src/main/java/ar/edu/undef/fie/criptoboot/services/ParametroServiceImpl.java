package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Parametro;
import ar.edu.undef.fie.criptoboot.repositories.ParametroRepository;
import org.springframework.stereotype.Service;

@Service
public class ParametroServiceImpl implements ParametroService{

    private final ParametroRepository parametroRepository;

    public ParametroServiceImpl(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }


    @Override
    public Parametro getParametros(int idUser) {
        //Cómo busco segun una clave foránea?
        return null;
    }

    @Override
    public void modificarParametros(Parametro parametro) {
        //Cómo modifico un campo?
    }
}
