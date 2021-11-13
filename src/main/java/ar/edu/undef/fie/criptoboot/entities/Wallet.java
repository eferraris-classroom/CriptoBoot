package ar.edu.undef.fie.criptoboot.entities;

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
    private int divisionesDisponible; //Dinero que no ha sido invertido
    private double balance; //Balance general contando las operaciones realizadas

    public Wallet(Usuario usuario, double disponible, int divisionesDisponible, double balance) {
        this.usuario = usuario;
        this.disponible = disponible;
        this.divisionesDisponible = divisionesDisponible;
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

    public int getDivisionesDisponible() {
        return divisionesDisponible;
    }

    public void setDivisionesDisponible(int divisionesDisponible) {
        this.divisionesDisponible = divisionesDisponible;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
