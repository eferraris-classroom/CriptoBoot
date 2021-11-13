package ar.edu.undef.fie.criptoboot.representations;

public class CriptomonedaRepresentation {
    private int orden;
    private String simbolo;
    private String nombre;
    private Double precio;
    private Double variacion;
    private Double volumen;
    private Boolean seguir;

    public CriptomonedaRepresentation(int orden, String simbolo, String nombre, Double precio, Double variacion, Double volumen, Boolean seguir) {
        this.orden = orden;
        this.simbolo = simbolo;
        this.nombre = nombre;
        this.precio = precio;
        this.variacion = variacion;
        this.volumen = volumen;
        this.seguir = seguir;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getVariacion() {
        return variacion;
    }

    public void setVariacion(Double variacion) {
        this.variacion = variacion;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public Boolean getSeguir() {
        return seguir;
    }

    public void setSeguir(Boolean seguir) {
        this.seguir = seguir;
    }
}
