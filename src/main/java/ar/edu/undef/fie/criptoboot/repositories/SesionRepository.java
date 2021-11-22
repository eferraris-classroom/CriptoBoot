package ar.edu.undef.fie.criptoboot.repositories;

import ar.edu.undef.fie.criptoboot.entities.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion,Integer> {
    Sesion findSesionByActiva(Boolean activa);
}
