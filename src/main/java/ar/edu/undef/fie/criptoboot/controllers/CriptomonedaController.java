package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import ar.edu.undef.fie.criptoboot.representations.CriptomonedaRepresentation;
import ar.edu.undef.fie.criptoboot.services.CriptomonedaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriptomonedaController {

    private final CriptomonedaService criptomonedaService;

    public CriptomonedaController(CriptomonedaService criptomonedaService) {
        this.criptomonedaService = criptomonedaService;
    }

    @RequestMapping(value = "usuarios/{idUser}/criptomonedas")
    public ResponseEntity<CriptomonedaRepresentation> getCriptomonedas(@PathVariable int idUser) {
        //Como debería hacer?
        //return ResponseEntity.ok(criptomonedaService.getCriptomonedas(idUser).stream().map(Criptomoneda::representation).collect()
        return null;

    }




}
