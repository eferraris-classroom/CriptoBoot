package ar.edu.undef.fie.criptoboot.entities;

import ar.edu.undef.fie.criptoboot.representations.CriptomonedaRepresentation;

import javax.persistence.*;

@Entity
public class Criptomoneda {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String id_cripto;
    private double current_price;
    private long market_cap_rank;
    private double total_volume;
    private double price_change_percentage24h;

    public Criptomoneda(){

    }

    public Criptomoneda(String symbol, String id_cripto, double current_price, long marketCapRank, double totalVolume, double price_change_percentage24h) {
        this.symbol = symbol;
        this.id_cripto = id_cripto;
        this.current_price = current_price;
        this.market_cap_rank = marketCapRank;
        this.total_volume = totalVolume;
        this.price_change_percentage24h = price_change_percentage24h;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getId_cripto() {
        return id_cripto;
    }

    public void setId_cripto(String idCripto) {
        this.id_cripto = idCripto;
    }

    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(double currentPrice) {
        this.current_price = currentPrice;
    }

    public long getMarket_cap_rank() {
        return market_cap_rank;
    }

    public void setMarket_cap_rank(long marketCapRank) {
        this.market_cap_rank = marketCapRank;
    }

    public double getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(double totalVolume) {
        this.total_volume = totalVolume;
    }

    public double getPrice_change_percentage24h() {
        return price_change_percentage24h;
    }

    public void setPrice_change_percentage24h(double priceChangePercentage24h) {
        this.price_change_percentage24h = priceChangePercentage24h;
    }

    public CriptomonedaRepresentation representation() {
        return new CriptomonedaRepresentation(id,symbol,id_cripto,current_price,market_cap_rank,total_volume,price_change_percentage24h);
    }
}
