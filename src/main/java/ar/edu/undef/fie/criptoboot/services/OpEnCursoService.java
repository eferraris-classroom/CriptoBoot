package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.OpEnCurso;

import java.util.List;

public interface OpEnCursoService {
    List<OpEnCurso> getOperaciones(int idUser);
    List<OpEnCurso> getOperacionesActivas(int idUser);
    void cargarOperacion (OpEnCurso opEnCurso);
    void modificarOperacion(OpEnCurso opEnCurso);
}
