package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.*;
import com.litesoftwares.coingecko.CoinGeckoApiClient;
import com.litesoftwares.coingecko.domain.Coins.CoinMarkets;
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class Boot {

    @Autowired
    private CriptomonedaService criptomonedaService;

    @Autowired
    private CriptoSeguidaService criptoSeguidaService;

    @Autowired
    private ParametroService parametroService;

    @Autowired
    private OpEnCursoService opEnCursoService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private UsuarioService usuarioService;

    Analisis analisis = new Analisis();

    CoinGeckoApiClient client = new CoinGeckoApiClientImpl();

    @Scheduled(fixedRate = 100000)
    public void Tarea(){
        int idUser = 1;
        //Usuario
        Usuario usuario= usuarioService.getUsuario(idUser);
        //Obtener los datos de la wallet
        System.out.println(usuario.getNombre());
        Wallet wallet=walletService.getWallet(idUser);


        //Obtener los parámetros
        Parametro parametros = parametroService.getParametros(idUser);

        System.out.println(parametros);

        //Obtener Criptomonedas seguidas
        List<CriptoSeguida> criptoSeguidasObjetos= criptoSeguidaService.getCriptosSeguidas(idUser);
        ArrayList<String> criptoSeguidas=new ArrayList<String>();
        for (int i = 0; i<criptoSeguidasObjetos.size();i++){
            criptoSeguidas.add(criptoSeguidasObjetos.get(i).getId_cripto());
        }

        //Obtener Criptomonedas en operaciones
        List<OpEnCurso> operacionesActivasObjetos = opEnCursoService.getOperacionesActivas(idUser);
        ArrayList<String> criptoEnOperacionesActivas = new ArrayList<String>();
        for (int i = 0; i<operacionesActivasObjetos.size(); i++){
            criptoEnOperacionesActivas.add(operacionesActivasObjetos.get(i).getId_cripto_hist());
        }


        //Consulta a la API
        ArrayList<String> criptomonedasASensar=new ArrayList<String>(criptoSeguidas);
        criptomonedasASensar.addAll(criptoEnOperacionesActivas); //Une las listas
        criptomonedasASensar.removeAll(criptoSeguidas); //Quita los duplicados existentes en las dos listas
        criptomonedasASensar.addAll(criptoSeguidas); //Une las listas
        String strCripto = String.join(",", criptomonedasASensar); //Convierte las listas en un solo String


        //Sensado de las criptos que me interesan
        List<CoinMarkets> criptomonedasSensadas = client.getCoinMarkets("usd",strCripto,"market_cap_desc",100,1,false,"1h,24h,7d");


        //Analisis y almacenamiento en BD
        for (int i = 0; i<criptomonedasSensadas.size();i++) {

            Criptomoneda criptomonedaNueva = new Criptomoneda(); //Creacion de la Criptomoneda que se va a almacenar (datos resumidos)
            //Desde el objeto CoinMarkets se crea uno Criptomonedas porque el CoinMarket contiene muchos datos que no me interesa persistir
            criptomonedaNueva.setId_cripto(criptomonedasSensadas.get(i).getId());
            criptomonedaNueva.setSymbol(criptomonedasSensadas.get(i).getSymbol());
            criptomonedaNueva.setCurrent_price(criptomonedasSensadas.get(i).getCurrentPrice());
            criptomonedaNueva.setMarket_cap_rank(criptomonedasSensadas.get(i).getMarketCapRank());
            criptomonedaNueva.setTotal_volume(criptomonedasSensadas.get(i).getTotalVolume());
            criptomonedaNueva.setPrice_change_percentage24h(criptomonedasSensadas.get(i).getPriceChangePercentage24h());

            //Almacenamiento
            criptomonedaService.persistirCriptomoneda(criptomonedaNueva);

            //Una vez que se creó la criptomoneda, tengo que ver si la cripto me interesa para vender o para comprar
            //Analisis de la criptomoneda para la venta
            if (criptoEnOperacionesActivas.contains(criptomonedaNueva.getId_cripto())){ //Si está dentro de las operaciones tengo que analizar, sino no me interesa vender
                for (int j=0; j<operacionesActivasObjetos.size();j++ ){
                    if(criptomonedaNueva.getId_cripto().equals(operacionesActivasObjetos.get(j).getId_cripto_hist())){ //Si es la criptomoneda de la operacion veo si se alcanzo algun precio de referencia
                        if ((criptomonedaNueva.getCurrent_price()>=operacionesActivasObjetos.get(j).getPrecio_finalizacion_ganancia())
                                || (criptomonedaNueva.getCurrent_price()<=operacionesActivasObjetos.get(j).getPrecio_finalizacion_perdida())) {
                            //Se alcanzó el precio para vender con ganancia o con perdida (es indistinto para la lógica) - Hay que vender
                            operacionesActivasObjetos.get(j).setActiva(false); //Se cierra la operación
                            operacionesActivasObjetos.get(j).setBalance_op((criptomonedaNueva.getCurrent_price()-operacionesActivasObjetos.get(j).getPrecio_inicio())*operacionesActivasObjetos.get(j).getCant_criptomoneda()); //Se actualiza el balance de la operacion
                            operacionesActivasObjetos.get(j).setBalance_porcentual((criptomonedaNueva.getCurrent_price()/operacionesActivasObjetos.get(j).getPrecio_inicio())-1); //Se actualiza el balance porcentual de la operacion
                            operacionesActivasObjetos.get(j).setFecha_hora_fin(Calendar.getInstance());
                            opEnCursoService.cargarOperacion(operacionesActivasObjetos.get(j));//Actualiza los datos de la BD
                            //Al cerrar la operacion, se pasa a tener disponible la cantidad de dinero resultante de la op
                            wallet.setDisponible(wallet.getDisponible()+operacionesActivasObjetos.get(j).getBalance_op());
                            wallet.setDivisiones_disponible(wallet.getDivisiones_disponible()+1);//Agrego una division más disponible
                            walletService.modificarWallet(wallet);//Actualiza los datos de la BD
                            System.out.println("Se cerró la operacion nro" + operacionesActivasObjetos.get(j).getId() + ".");
                        }
                        operacionesActivasObjetos.remove(operacionesActivasObjetos.get(j)); //Lo saco porque ya no lo voy a necesitar mas
                    }//si no es, paso a la siguiente directamente
                }
            }


            //Analisis de la criptomoneda para la compra
            if (wallet.getDivisiones_disponible()>0 && wallet.getDisponible()>0){//Si no tengo dinero disponible ya ni es necesario analizar
                if (criptoSeguidas.contains(criptomonedaNueva.getId_cripto())){//si está dentro de las criptos seguidas entonces analizo
                    if (analisis.analizarCriptomoneda(criptomonedaNueva)){ //Si el resultado del analisis es que tengo que invertir, entonces compro
                        //RealizarCompra
                        System.out.println("El analisis de " + criptomonedaNueva.getSymbol() + " fue positivo, se realiza la compra.");
                        OpEnCurso nuevaOp = new OpEnCurso(); //Se crea la operacion en curso
                        nuevaOp.setUsuario(usuario);
                        nuevaOp.setId_cripto_hist(criptomonedaNueva.getId_cripto());
                        nuevaOp.setCant_criptomoneda((wallet.getDisponible()/wallet.getDivisiones_disponible())/criptomonedaNueva.getCurrent_price());
                        nuevaOp.setFecha_hora_inicio(Calendar.getInstance());
                        nuevaOp.setPrecio_inicio(criptomonedaNueva.getCurrent_price());
                        nuevaOp.setBalance_porcentual(0.0);
                        nuevaOp.setBalance_op(0.0);
                        nuevaOp.setPrecio_finalizacion_ganancia(nuevaOp.getPrecio_inicio()*(1+parametros.getGan_por_op()));
                        nuevaOp.setPrecio_finalizacion_perdida(nuevaOp.getPrecio_inicio()*(1-parametros.getPer_por_op()));
                        nuevaOp.setActiva(true);
                        opEnCursoService.cargarOperacion(nuevaOp);//Se persiste la operacion

                        //Actualizacion de la wallet
                        wallet.setDisponible(wallet.getDisponible()-nuevaOp.getPrecio_inicio()*nuevaOp.getCant_criptomoneda());
                        wallet.setDivisiones_disponible(wallet.getDivisiones_disponible()-1);//Se quita una division disponible
                        walletService.modificarWallet(wallet);//Actualiza los datos de la BD
                        System.out.println("Se creó una nueva operacion.");

                    }else{
                        System.out.println("Al analizar " + criptomonedaNueva.getSymbol() + ", la estrategia estableció que no es conveniente comprar");
                    }
                }
            }else{
                System.out.println("No hay dinero disponible para comprar " + criptomonedaNueva.getSymbol() + ". Directamente no se analiza ");
            }

        }

    }



}
