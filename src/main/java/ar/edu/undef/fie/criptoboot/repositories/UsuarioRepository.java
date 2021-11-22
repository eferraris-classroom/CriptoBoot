package ar.edu.undef.fie.criptoboot.repositories;

import ar.edu.undef.fie.criptoboot.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByEmail(String email);

}
