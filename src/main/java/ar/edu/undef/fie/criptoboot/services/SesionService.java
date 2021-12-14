package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Sesion;
import ar.edu.undef.fie.criptoboot.entities.Usuario;

public interface SesionService {
    Sesion getSesionActiva();
    void nuevaSesion(Usuario usuario);
    void cerrarSesion();
    boolean validarSesion(String token);
}
