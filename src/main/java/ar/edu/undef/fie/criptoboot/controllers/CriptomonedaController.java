package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import ar.edu.undef.fie.criptoboot.representations.CriptomonedaRepresentation;
import ar.edu.undef.fie.criptoboot.services.CriptomonedaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CriptomonedaController {

    private final CriptomonedaService criptomonedaService;

    public CriptomonedaController(CriptomonedaService criptomonedaService) {
        this.criptomonedaService = criptomonedaService;
    }

    @GetMapping(value = "criptomonedas")
    public ResponseEntity<List<CriptomonedaRepresentation>> getCriptomonedas() {
        return ResponseEntity.ok(criptomonedaService.getCriptomonedas()
                .stream()
                .map(Criptomoneda::representation).
                collect(Collectors.toList()));

    }




}
