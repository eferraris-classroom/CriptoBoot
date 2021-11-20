package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import ar.edu.undef.fie.criptoboot.representations.CriptoSeguidaRepresentation;
import ar.edu.undef.fie.criptoboot.representations.CriptomonedaRepresentation;
import ar.edu.undef.fie.criptoboot.requests.CriptoSeguidaRequest;
import ar.edu.undef.fie.criptoboot.services.CriptoSeguidaService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CriptoSeguidaController {

    private final CriptoSeguidaService criptoSeguidaService;


    public CriptoSeguidaController(CriptoSeguidaService criptoSeguidaService) {
        this.criptoSeguidaService = criptoSeguidaService;
    }

    @GetMapping(value = "usuarios/{idUser}/criptoSeguidas")
    public ResponseEntity<List<CriptoSeguidaRepresentation>> getCriptoSeguidas(@PathVariable int idUser) {
        return ResponseEntity.ok(criptoSeguidaService.getCriptosSeguidas(idUser)
                .stream()
                .map(CriptoSeguida::representation).
                collect(Collectors.toList()));

    }

    @DeleteMapping(value = "/criptoSeguidas/{idCriptoSeguida}")
    public  ResponseEntity<String> quitarCriptoSeguida(@PathVariable int idCriptoSeguida) throws NotFoundException {
        criptoSeguidaService.quitarCriptoSeguida(idCriptoSeguida);
        return new ResponseEntity<>(
                "Cripto Seguida eliminada con éxito",
                HttpStatus.OK);
    }


    @PostMapping(value = "criptoSeguidas")
    public ResponseEntity<CriptoSeguidaRepresentation> agregarCriptoSeguida(@RequestBody CriptoSeguidaRequest criptoSeguidaRequest) {
        return ResponseEntity.ok(criptoSeguidaService.agregarCriptoSeguida(criptoSeguidaRequest).representation());
    }

}
