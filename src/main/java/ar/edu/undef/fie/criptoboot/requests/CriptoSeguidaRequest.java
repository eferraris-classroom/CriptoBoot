package ar.edu.undef.fie.criptoboot.requests;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.entities.Usuario;

import java.util.stream.Collectors;

public class CriptoSeguidaRequest {

    private String id_cripto;
    private Usuario usuario;

    public CriptoSeguidaRequest(String id_cripto, Usuario usuario) {
        this.id_cripto = id_cripto;
        this.usuario = usuario;
    }

    public String getId_cripto() {
        return id_cripto;
    }

    public void setId_cripto(String id_cripto) {
        this.id_cripto = id_cripto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CriptoSeguida construct() {
        return new CriptoSeguida(id_cripto, usuario);
    }


}
