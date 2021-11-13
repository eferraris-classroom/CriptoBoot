package ar.edu.undef.fie.criptoboot.repositories;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriptomonedaRepository extends JpaRepository<Criptomoneda,Integer> {
}
