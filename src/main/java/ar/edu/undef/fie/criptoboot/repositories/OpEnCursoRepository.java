package ar.edu.undef.fie.criptoboot.repositories;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.entities.OpEnCurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpEnCursoRepository extends JpaRepository<OpEnCurso,Integer> {
    List<OpEnCurso> findByUsuarioId(int idUser);
    List<OpEnCurso> findByUsuarioIdAndActiva(int idUser,boolean activa);

}
