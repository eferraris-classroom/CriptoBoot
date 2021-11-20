package ar.edu.undef.fie.criptoboot.repositories;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriptoSeguidaRepository extends JpaRepository<CriptoSeguida,Integer> {

    List<CriptoSeguida>findByUsuarioId(int idUser);
}
