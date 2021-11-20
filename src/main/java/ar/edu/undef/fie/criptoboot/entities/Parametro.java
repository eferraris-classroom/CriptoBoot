package ar.edu.undef.fie.criptoboot.entities;

import ar.edu.undef.fie.criptoboot.representations.OpEnCursoRepresentation;
import ar.edu.undef.fie.criptoboot.representations.ParametroRepresentation;

import javax.persistence.*;

@Entity
public class Parametro {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parametro_id")
    private Usuario usuario;
    private double gan_por_op;
    private double per_por_op;
    private double variacion_entr_caidas;

    public Parametro(Usuario usuario, double gan_por_op, double per_por_op, double variacion_entr_caidas) {
        this.usuario = usuario;
        this.gan_por_op = gan_por_op;
        this.per_por_op = per_por_op;
        this.variacion_entr_caidas = variacion_entr_caidas;
    }

    public Parametro() {

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

    public double getGan_por_op() {
        return gan_por_op;
    }

    public void setGan_por_op(double ganPorOp) {
        this.gan_por_op = ganPorOp;
    }

    public double getPer_por_op() {
        return per_por_op;
    }

    public void setPer_por_op(double perPorOp) {
        this.per_por_op = perPorOp;
    }

    public double getVariacion_entr_caidas() {
        return variacion_entr_caidas;
    }

    public void setVariacion_entr_caidas(double variacionEstrCaidas) {
        this.variacion_entr_caidas = variacionEstrCaidas;
    }

    public ParametroRepresentation representation() {
        return new ParametroRepresentation((int)id,usuario,gan_por_op,per_por_op,variacion_entr_caidas);
    }


}
