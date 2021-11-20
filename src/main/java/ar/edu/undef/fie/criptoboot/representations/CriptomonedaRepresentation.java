package ar.edu.undef.fie.criptoboot.representations;

public class CriptomonedaRepresentation {
    private Long id;
    private String symbol;
    private String id_cripto;
    private double current_price;
    private long market_cap_rank;
    private double total_volume;
    private double price_change_percentage24h;

    public CriptomonedaRepresentation(Long id, String symbol, String id_cripto, double current_price, long market_cap_rank, double total_volume, double price_change_percentage24h) {
        this.id = id;
        this.symbol = symbol;
        this.id_cripto = id_cripto;
        this.current_price = current_price;
        this.market_cap_rank = market_cap_rank;
        this.total_volume = total_volume;
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

    public void setId_cripto(String id_cripto) {
        this.id_cripto = id_cripto;
    }

    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }

    public long getMarket_cap_rank() {
        return market_cap_rank;
    }

    public void setMarket_cap_rank(long market_cap_rank) {
        this.market_cap_rank = market_cap_rank;
    }

    public double getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(double total_volume) {
        this.total_volume = total_volume;
    }

    public double getPrice_change_percentage24h() {
        return price_change_percentage24h;
    }

    public void setPrice_change_percentage24h(double price_change_percentage24h) {
        this.price_change_percentage24h = price_change_percentage24h;
    }
}
