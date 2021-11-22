package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Parametro;
import ar.edu.undef.fie.criptoboot.entities.Usuario;
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

    @Override
    public void crearParametros(Usuario usuario) {
        Parametro nuevosParametros = new Parametro();
        nuevosParametros.setUsuario(usuario);
        nuevosParametros.setGan_por_op(0.1);
        nuevosParametros.setPer_por_op(0.05);
        nuevosParametros.setVariacion_entr_caidas(0.1);
        parametroRepository.save(nuevosParametros);
    }
}
