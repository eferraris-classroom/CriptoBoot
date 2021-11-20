package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import ar.edu.undef.fie.criptoboot.repositories.CriptomonedaRepository;
import com.litesoftwares.coingecko.CoinGeckoApiClient;
import com.litesoftwares.coingecko.domain.Coins.CoinMarkets;
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CriptomonedaServiceImpl implements CriptomonedaService{

    private final CriptomonedaRepository criptomonedaRepository;

    public CriptomonedaServiceImpl(CriptomonedaRepository criptomonedaRepository) {
        this.criptomonedaRepository = criptomonedaRepository;
    }

    @Override
    public List<Criptomoneda> getCriptomonedas() {
        int cantCriptosASensar = 20;
        //Creacion del cliente para la consulta a la api de CoinGecko
        CoinGeckoApiClient client = (CoinGeckoApiClient) new CoinGeckoApiClientImpl();
        List<CoinMarkets> criptomonedasSensadas = client.getCoinMarkets("usd","","market_cap_desc",cantCriptosASensar,1,false,"1h,24h,7d"); //Obtiene una lista de objetos CoinMarkets
        //Convertir CoinMarkets a Criptomonedas

        ArrayList<Criptomoneda> criptomonedasARetornar = new ArrayList<Criptomoneda>();
        for (int i = 0; i<criptomonedasSensadas.size();i++) {
            Criptomoneda criptomonedaNueva = new Criptomoneda(); //Creacion de la Criptomoneda que se va a almacenar (datos resumidos)
            //Desde el objeto CoinMarkets se crea uno Criptomonedas porque el CoinMarket contiene muchos datos que no me interesan
            criptomonedaNueva.setId(1L);
            criptomonedaNueva.setId_cripto(criptomonedasSensadas.get(i).getId());
            criptomonedaNueva.setSymbol(criptomonedasSensadas.get(i).getSymbol());
            criptomonedaNueva.setCurrent_price(criptomonedasSensadas.get(i).getCurrentPrice());
            criptomonedaNueva.setMarket_cap_rank(criptomonedasSensadas.get(i).getMarketCapRank());
            criptomonedaNueva.setTotal_volume(criptomonedasSensadas.get(i).getTotalVolume());
            criptomonedaNueva.setPrice_change_percentage24h(criptomonedasSensadas.get(i).getPriceChangePercentage24h());
            criptomonedasARetornar.add(criptomonedaNueva);
        }
        return criptomonedasARetornar;
    }

    @Override
    public void persistirCriptomoneda(Criptomoneda criptomoneda) {
        criptomonedaRepository.save(criptomoneda);
    }


}
