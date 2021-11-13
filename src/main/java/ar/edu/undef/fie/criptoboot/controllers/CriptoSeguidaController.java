package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.services.CriptoSeguidaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriptoSeguidaController {

    private final CriptoSeguidaService criptoSeguidaService;


    public CriptoSeguidaController(CriptoSeguidaService criptoSeguidaService) {
        this.criptoSeguidaService = criptoSeguidaService;
    }

    @RequestMapping(value = "usuarios/{idUser}/criptoSeguidas/{idCriptoSeguida}", method = RequestMethod.DELETE)
    public void quitarCriptoSeguida(@PathVariable String symbol, int idUser) {
        criptoSeguidaService.quitarCriptoSeguida(idUser,symbol);
    }

    @RequestMapping(value = "usuarios/{idUser}/criptoSeguidas/{idCriptoSeguida}", method = RequestMethod.POST)
    public void agregarCriptoSeguida(@PathVariable String symbol, int idUser) {
        criptoSeguidaService.agregarCriptoSeguida(idUser,symbol);
    }
}
