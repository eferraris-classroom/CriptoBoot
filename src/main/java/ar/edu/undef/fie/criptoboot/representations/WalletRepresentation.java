package ar.edu.undef.fie.criptoboot.representations;

import ar.edu.undef.fie.criptoboot.entities.Usuario;

public class WalletRepresentation {

    private Long id;
    private Usuario usuario;
    private double disponible; //Dinero que no ha sido invertido
    private int divisiones_disponible; //Dinero que no ha sido invertido
    private double balance; //Balance general contando las operaciones realizadas

    public WalletRepresentation(Long id, Usuario usuario, double disponible, int divisiones_disponible, double balance) {
        this.id = id;
        this.usuario = usuario;
        this.disponible = disponible;
        this.divisiones_disponible = divisiones_disponible;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getDisponible() {
        return disponible;
    }

    public void setDisponible(double disponible) {
        this.disponible = disponible;
    }

    public int getDivisiones_disponible() {
        return divisiones_disponible;
    }

    public void setDivisiones_disponible(int divisiones_disponible) {
        this.divisiones_disponible = divisiones_disponible;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
