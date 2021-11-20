package ar.edu.undef.fie.criptoboot.representations;

import ar.edu.undef.fie.criptoboot.entities.Usuario;

public class CriptoSeguidaRepresentation {

    private int id;
    private String id_cripto;
    private Usuario usuario;

    public CriptoSeguidaRepresentation(int id, String id_cripto, Usuario usuario) {
        this.id = id;
        this.id_cripto = id_cripto;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
