package ar.edu.undef.fie.criptoboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parametro {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private long idUser;
    private double ganPorOp;
    private double perPorOp;
    private double variacionEstrCaidas;

    public Parametro(long idUser, double ganPorOp, double perPorOp, double variacionEstrCaidas) {
        this.idUser = idUser;
        this.ganPorOp = ganPorOp;
        this.perPorOp = perPorOp;
        this.variacionEstrCaidas = variacionEstrCaidas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public double getGanPorOp() {
        return ganPorOp;
    }

    public void setGanPorOp(double ganPorOp) {
        this.ganPorOp = ganPorOp;
    }

    public double getPerPorOp() {
        return perPorOp;
    }

    public void setPerPorOp(double perPorOp) {
        this.perPorOp = perPorOp;
    }

    public double getVariacionEstrCaidas() {
        return variacionEstrCaidas;
    }

    public void setVariacionEstrCaidas(double variacionEstrCaidas) {
        this.variacionEstrCaidas = variacionEstrCaidas;
    }
}
