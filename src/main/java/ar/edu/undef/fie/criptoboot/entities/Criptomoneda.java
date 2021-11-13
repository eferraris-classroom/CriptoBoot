package ar.edu.undef.fie.criptoboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Criptomoneda {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String idCripto;
    private double currentPrice;
    private long marketCapRank;
    private double totalVolume;
    private double priceChangePercentage24h;

    public Criptomoneda(String symbol, String idCripto, double currentPrice, long marketCapRank, double totalVolume, double priceChangePercentage24h) {
        this.symbol = symbol;
        this.idCripto = idCripto;
        this.currentPrice = currentPrice;
        this.marketCapRank = marketCapRank;
        this.totalVolume = totalVolume;
        this.priceChangePercentage24h = priceChangePercentage24h;
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

    public String getIdCripto() {
        return idCripto;
    }

    public void setIdCripto(String idCripto) {
        this.idCripto = idCripto;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public long getMarketCapRank() {
        return marketCapRank;
    }

    public void setMarketCapRank(long marketCapRank) {
        this.marketCapRank = marketCapRank;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public double getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }

    public void setPriceChangePercentage24h(double priceChangePercentage24h) {
        this.priceChangePercentage24h = priceChangePercentage24h;
    }
}
