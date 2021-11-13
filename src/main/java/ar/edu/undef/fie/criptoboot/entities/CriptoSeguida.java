package ar.edu.undef.fie.criptoboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CriptoSeguida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idCripto;
    private Long idUser;

    public CriptoSeguida(String idCripto, Long idUser) {
        this.idCripto = idCripto;
        this.idUser = idUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCripto() {
        return idCripto;
    }

    public void setIdCripto(String idCripto) {
        this.idCripto = idCripto;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
