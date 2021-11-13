package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Parametro;
import ar.edu.undef.fie.criptoboot.services.ParametroService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParametroController {

    private final ParametroService parametroService;

    public ParametroController(ParametroService parametroService) {
        this.parametroService = parametroService;
    }

    @RequestMapping(value = "usuarios/{idUser}/parametros")
    public Parametro getParametros(@PathVariable int idUser) {
        return parametroService.getParametros(idUser);
    }

    @RequestMapping(value = "usuarios/{idUser}/parametros", method = RequestMethod.PUT)
    public void modificarParametros(@RequestBody Parametro parametros) {
        parametroService.modificarParametros(parametros);
    }
}
