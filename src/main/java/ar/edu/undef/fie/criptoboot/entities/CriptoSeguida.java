package ar.edu.undef.fie.criptoboot.entities;

import javax.persistence.*;

@Entity
public class CriptoSeguida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String idCripto;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "criptoSeguida_id")
    private Usuario usuario;

    public CriptoSeguida(String idCripto, Usuario usuario) {
        this.idCripto = idCripto;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCripto() {
        return idCripto;
    }

    public void setIdCripto(String idCripto) {
        this.idCripto = idCripto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
