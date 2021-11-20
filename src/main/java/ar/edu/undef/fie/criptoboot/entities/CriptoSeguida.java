package ar.edu.undef.fie.criptoboot.entities;

import ar.edu.undef.fie.criptoboot.representations.CriptoSeguidaRepresentation;
import ar.edu.undef.fie.criptoboot.services.CriptoSeguidaService;

import javax.persistence.*;

@Entity
public class CriptoSeguida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String id_cripto;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "criptoSeguida_id")
    private Usuario usuario;

    public CriptoSeguida() {

    }
    public CriptoSeguida(String id_cripto, Usuario usuario) {
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

    public void setId_cripto(String idCripto) {
        this.id_cripto = idCripto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CriptoSeguidaRepresentation representation() {
        return new CriptoSeguidaRepresentation(id,id_cripto,usuario);
    }
}
