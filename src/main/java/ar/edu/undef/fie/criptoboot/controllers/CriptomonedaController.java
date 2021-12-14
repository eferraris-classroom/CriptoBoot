package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import ar.edu.undef.fie.criptoboot.representations.CriptomonedaRepresentation;
import ar.edu.undef.fie.criptoboot.services.CriptomonedaService;
import ar.edu.undef.fie.criptoboot.services.SesionService;
import ar.edu.undef.fie.criptoboot.utils.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CriptomonedaController {

    private final CriptomonedaService criptomonedaService;
    private final SesionService sesionService;

    public CriptomonedaController(CriptomonedaService criptomonedaService, SesionService sesionService) {
        this.criptomonedaService = criptomonedaService;
        this.sesionService = sesionService;

    }

    @GetMapping(value = "criptomonedas")
    public ResponseEntity<List<CriptomonedaRepresentation>> getCriptomonedas(@RequestHeader(value="Authorization") String token) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<List<CriptomonedaRepresentation>>(HttpStatus.UNAUTHORIZED);
        }else {

            return ResponseEntity.ok(criptomonedaService.getCriptomonedas()
                    .stream()
                    .map(Criptomoneda::representation).
                    collect(Collectors.toList()));
        }
    }




}
