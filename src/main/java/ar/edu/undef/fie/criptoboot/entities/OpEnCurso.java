package ar.edu.undef.fie.criptoboot.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class OpEnCurso {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "opEnCurso_id")
    private Usuario usuario;
    private String idCriptoHist;
    private double cantCriptomoneda;
    private Double balanceOp;
    private Double balancePorcentual;
    private Calendar fechaHoraInicio;
    private Calendar fechaHoraFin;
    private Double precioInicio;
    private Double precioFinalizacionGanancia;
    private Double precioFinalizacionPerdida;
    private Boolean activa;

    public OpEnCurso(Usuario usuario, String idCriptoHist, double cantCriptomoneda, Double balanceOp, Double balancePorcentual, Calendar fechaHoraInicio, Calendar fechaHoraFin, Double precioInicio, Double precioFinalizacionGanancia, Double precioFinalizacionPerdida, Boolean activa) {
        this.usuario = usuario;
        this.idCriptoHist = idCriptoHist;
        this.cantCriptomoneda = cantCriptomoneda;
        this.balanceOp = balanceOp;
        this.balancePorcentual = balancePorcentual;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.precioInicio = precioInicio;
        this.precioFinalizacionGanancia = precioFinalizacionGanancia;
        this.precioFinalizacionPerdida = precioFinalizacionPerdida;
        this.activa = activa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdCriptoHist() {
        return idCriptoHist;
    }

    public void setIdCriptoHist(String idCriptoHist) {
        this.idCriptoHist = idCriptoHist;
    }

    public double getCantCriptomoneda() {
        return cantCriptomoneda;
    }

    public void setCantCriptomoneda(double cantCriptomoneda) {
        this.cantCriptomoneda = cantCriptomoneda;
    }

    public Double getBalanceOp() {
        return balanceOp;
    }

    public void setBalanceOp(Double balanceOp) {
        this.balanceOp = balanceOp;
    }

    public Double getBalancePorcentual() {
        return balancePorcentual;
    }

    public void setBalancePorcentual(Double balancePorcentual) {
        this.balancePorcentual = balancePorcentual;
    }

    public Calendar getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Calendar fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Calendar getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Calendar fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Double getPrecioInicio() {
        return precioInicio;
    }

    public void setPrecioInicio(Double precioInicio) {
        this.precioInicio = precioInicio;
    }

    public Double getPrecioFinalizacionGanancia() {
        return precioFinalizacionGanancia;
    }

    public void setPrecioFinalizacionGanancia(Double precioFinalizacionGanancia) {
        this.precioFinalizacionGanancia = precioFinalizacionGanancia;
    }

    public Double getPrecioFinalizacionPerdida() {
        return precioFinalizacionPerdida;
    }

    public void setPrecioFinalizacionPerdida(Double precioFinalizacionPerdida) {
        this.precioFinalizacionPerdida = precioFinalizacionPerdida;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}
