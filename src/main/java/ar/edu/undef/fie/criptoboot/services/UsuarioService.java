package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario getUsuario(String email);

    void eliminar(int id);

    Usuario registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
