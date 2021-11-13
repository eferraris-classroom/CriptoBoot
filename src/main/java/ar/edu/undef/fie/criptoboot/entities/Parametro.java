package ar.edu.undef.fie.criptoboot.entities;

import javax.persistence.*;

@Entity
public class Parametro {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parametro_id")
    private Usuario usuario;
    private double ganPorOp;
    private double perPorOp;
    private double variacionEstrCaidas;

    public Parametro(Usuario usuario, double ganPorOp, double perPorOp, double variacionEstrCaidas) {
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
