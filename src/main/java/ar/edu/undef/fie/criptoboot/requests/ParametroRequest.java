package ar.edu.undef.fie.criptoboot.requests;

import ar.edu.undef.fie.criptoboot.entities.Parametro;
import ar.edu.undef.fie.criptoboot.entities.Usuario;


public class ParametroRequest {

    private long id;
    private Usuario usuario;
    private double gan_por_op;
    private double per_por_op;
    private double variacion_entr_caidas;

    public ParametroRequest(long id, Usuario usuario, double gan_por_op, double per_por_op, double variacion_entr_caidas) {
        this.id = id;
        this.usuario = usuario;
        this.gan_por_op = gan_por_op;
        this.per_por_op = per_por_op;
        this.variacion_entr_caidas = variacion_entr_caidas;
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

    public void setGan_por_op(double gan_por_op) {
        this.gan_por_op = gan_por_op;
    }

    public double getPer_por_op() {
        return per_por_op;
    }

    public void setPer_por_op(double per_por_op) {
        this.per_por_op = per_por_op;
    }

    public double getVariacion_entr_caidas() {
        return variacion_entr_caidas;
    }

    public void setVariacion_entr_caidas(double variacion_entr_caidas) {
        this.variacion_entr_caidas = variacion_entr_caidas;
    }

    public Parametro construct(){
        Parametro parametro = new Parametro(usuario,gan_por_op,per_por_op,variacion_entr_caidas);
        parametro.setId(id);
        return parametro;
    }
}
