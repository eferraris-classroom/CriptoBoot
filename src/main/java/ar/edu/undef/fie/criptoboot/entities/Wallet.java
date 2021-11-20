package ar.edu.undef.fie.criptoboot.entities;

import ar.edu.undef.fie.criptoboot.representations.WalletRepresentation;

import javax.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wallet_id")
    private Usuario usuario;
    private double disponible; //Dinero que no ha sido invertido
    private int divisiones_disponible; //Dinero que no ha sido invertido
    private double balance; //Balance general contando las operaciones realizadas

    public Wallet(Usuario usuario, double disponible, int divisionesDisponible, double balance) {
        this.usuario = usuario;
        this.disponible = disponible;
        this.divisiones_disponible = divisionesDisponible;
        this.balance = balance;
    }

    public Wallet() {

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

    public void setDivisiones_disponible(int divisionesDisponible) {
        this.divisiones_disponible = divisionesDisponible;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public WalletRepresentation representation() {
        return new WalletRepresentation(id,usuario,disponible,divisiones_disponible,balance);
    }
}
