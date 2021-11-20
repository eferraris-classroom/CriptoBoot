package ar.edu.undef.fie.criptoboot.representations;

import ar.edu.undef.fie.criptoboot.entities.Usuario;

import java.util.Calendar;

public class OpEnCursoRepresentation {
    private int id;
    private Usuario usuario;
    private String id_cripto_hist;
    private double cant_criptomoneda;
    private Double balance_op;
    private Double balance_porcentual;
    private Calendar fecha_hora_inicio;
    private Calendar fecha_hora_fin;
    private Double precio_inicio;
    private Double precio_finalizacion_ganancia;
    private Double precio_finalizacion_perdida;
    private Boolean activa;

    public OpEnCursoRepresentation(int id, Usuario usuario, String id_cripto_hist, double cant_criptomoneda, Double balance_op, Double balance_porcentual, Calendar fecha_hora_inicio, Calendar fecha_hora_fin, Double precio_inicio, Double precio_finalizacion_ganancia, Double precio_finalizacion_perdida, Boolean activa) {
        this.id = id;
        this.usuario = usuario;
        this.id_cripto_hist = id_cripto_hist;
        this.cant_criptomoneda = cant_criptomoneda;
        this.balance_op = balance_op;
        this.balance_porcentual = balance_porcentual;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.precio_inicio = precio_inicio;
        this.precio_finalizacion_ganancia = precio_finalizacion_ganancia;
        this.precio_finalizacion_perdida = precio_finalizacion_perdida;
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

    public String getId_cripto_hist() {
        return id_cripto_hist;
    }

    public void setId_cripto_hist(String id_cripto_hist) {
        this.id_cripto_hist = id_cripto_hist;
    }

    public double getCant_criptomoneda() {
        return cant_criptomoneda;
    }

    public void setCant_criptomoneda(double cant_criptomoneda) {
        this.cant_criptomoneda = cant_criptomoneda;
    }

    public Double getBalance_op() {
        return balance_op;
    }

    public void setBalance_op(Double balance_op) {
        this.balance_op = balance_op;
    }

    public Double getBalance_porcentual() {
        return balance_porcentual;
    }

    public void setBalance_porcentual(Double balance_porcentual) {
        this.balance_porcentual = balance_porcentual;
    }

    public Calendar getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(Calendar fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public Calendar getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public void setFecha_hora_fin(Calendar fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public Double getPrecio_inicio() {
        return precio_inicio;
    }

    public void setPrecio_inicio(Double precio_inicio) {
        this.precio_inicio = precio_inicio;
    }

    public Double getPrecio_finalizacion_ganancia() {
        return precio_finalizacion_ganancia;
    }

    public void setPrecio_finalizacion_ganancia(Double precio_finalizacion_ganancia) {
        this.precio_finalizacion_ganancia = precio_finalizacion_ganancia;
    }

    public Double getPrecio_finalizacion_perdida() {
        return precio_finalizacion_perdida;
    }

    public void setPrecio_finalizacion_perdida(Double precio_finalizacion_perdida) {
        this.precio_finalizacion_perdida = precio_finalizacion_perdida;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }


}
