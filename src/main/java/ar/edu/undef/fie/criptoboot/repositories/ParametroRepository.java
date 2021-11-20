package ar.edu.undef.fie.criptoboot.repositories;

import ar.edu.undef.fie.criptoboot.entities.OpEnCurso;
import ar.edu.undef.fie.criptoboot.entities.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParametroRepository extends JpaRepository<Parametro,Integer> {

    Parametro findByUsuarioId(int idUser);
}
