package com.litesoftwares.coingecko;//package com.litesoftwares.coingecko.examples;

import com.litesoftwares.coingecko.constant.Currency;
import com.litesoftwares.coingecko.domain.Coins.CoinMarkets;
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class CoinsExample {
    public static void main(String[] args) throws InterruptedException, ParseException {
        String OMGContract = "0xd26114cd6EE289AccF82350c8d8487fedB8A0C07";
        String platform = "ethereum";
/*
        CoinGeckoApiClient client = new CoinGeckoApiClientImpl();

        //List<CoinList> coinList = client.getCoinList();
        //System.out.println(coinList);

        //Map<String, Map<String, Double>> bitcoin = client.getPrice("tether",Currency.USD);

        //Map<String, Map<String, Double>> bitcoin5 = client.getPrice("bitcoin",Currency.USD,true,true,true,true);


        List<CoinMarkets> bitcoin5 = client.getCoinMarkets("usd","bitcoin","market_cap_desc",100,1,false,"1h,24h,7d");

        List<CoinMarkets> criptomonedas = client.getCoinMarkets("usd","","market_cap_desc",50,1,false,"1h,24h,7d");

        System.out.println(criptomonedas.size());

        System.out.println(criptomonedas.get(1));
        System.out.println(criptomonedas.get(2));
        System.out.println(criptomonedas.get(3));
        System.out.println(criptomonedas.get(4));

        //PARA PARSEAR LA FECHA EN UNA VARIABLE CALENDAR, EN LA TZ BS-AS
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        sdf.setTimeZone(TimeZone.getTimeZone("America/Buenos_Aires"));
        cal.setTime(sdf.parse(bitcoin5.get(0).getLastUpdated()));




        System.out.println(bitcoin5.get(0));
        System.out.println(bitcoin5.get(0).getLastUpdated());

        System.out.println(cal);
        System.out.println(sdf.parse(bitcoin5.get(0).getLastUpdated()));
        System.out.println(sdf.format(cal.getTime()));


        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        double bitcoinPrice = bitcoin.get("tether").get(Currency.USD);
        System.out.printf("%nEl valor de la variable cantidad es %.6f", bitcoinPrice);
        System.out.println(bitcoinPrice);

        //CoinGeckoApiClient client2 = new CoinGeckoApiClientImpl();

        Map<String, Map<String, Double>> bitcoin2 = client.getPrice("bitcoin",Currency.USD);

        System.out.println(bitcoin2);

        double bitcoinPrice2 = bitcoin2.get("bitcoin").get(Currency.USD);

        System.out.println(bitcoinPrice2);
        System.out.println(bitcoinPrice2*bitcoinPrice);
*/
    }
}
