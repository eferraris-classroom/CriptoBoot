package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.OpEnCurso;
import ar.edu.undef.fie.criptoboot.repositories.OpEnCursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpEnCursoServiceImpl implements OpEnCursoService{

    private final OpEnCursoRepository opEnCursoRepository;

    public OpEnCursoServiceImpl(OpEnCursoRepository opEnCursoRepository) {
        this.opEnCursoRepository = opEnCursoRepository;
    }


    @Override
    public List<OpEnCurso> getOperaciones(int idUser) {
        return opEnCursoRepository.findByUsuarioId(idUser);
    }

    @Override
    public List<OpEnCurso> getOperacionesActivas(int idUser) {
       return opEnCursoRepository.findByUsuarioIdAndActiva(idUser,true);
    }

    @Override
    public void cargarOperacion(OpEnCurso opEnCurso) {
        opEnCursoRepository.save(opEnCurso);
    }

    @Override
    public void modificarOperacion(OpEnCurso opEnCurso) {
        //Como acualizo un campo?
    }
}
