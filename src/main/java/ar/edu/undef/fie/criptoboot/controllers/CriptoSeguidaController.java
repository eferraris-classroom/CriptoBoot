package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.CriptoSeguida;
import ar.edu.undef.fie.criptoboot.representations.CriptoSeguidaRepresentation;
import ar.edu.undef.fie.criptoboot.requests.CriptoSeguidaRequest;
import ar.edu.undef.fie.criptoboot.services.CriptoSeguidaService;
import ar.edu.undef.fie.criptoboot.services.SesionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CriptoSeguidaController {

    private final CriptoSeguidaService criptoSeguidaService;
    private final SesionService sesionService;

    public CriptoSeguidaController(CriptoSeguidaService criptoSeguidaService, SesionService sesionService) {
        this.criptoSeguidaService = criptoSeguidaService;
        this.sesionService = sesionService;
    }

    @GetMapping(value = "usuarios/{idUser}/criptoSeguidas")
    public ResponseEntity<List<CriptoSeguidaRepresentation>> getCriptoSeguidas(@PathVariable int idUser) {
        return ResponseEntity.ok(criptoSeguidaService.getCriptosSeguidas(idUser)
                .stream()
                .map(CriptoSeguida::representation).
                collect(Collectors.toList()));

    }

    @DeleteMapping(value = "/criptoSeguidas/{idCriptoSeguida}")
    public  ResponseEntity<String> quitarCriptoSeguida(@RequestHeader(value="Authorization") String token, @PathVariable int idCriptoSeguida) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        } else {
            criptoSeguidaService.quitarCriptoSeguida(idCriptoSeguida);
            return ResponseEntity.ok("Cripto Seguida eliminada con éxito");

        }
    }

    @PostMapping(value = "criptoSeguidas")
    public ResponseEntity<CriptoSeguidaRepresentation> agregarCriptoSeguida(@RequestHeader(value="Authorization") String token, @RequestBody CriptoSeguidaRequest criptoSeguidaRequest) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<CriptoSeguidaRepresentation>(HttpStatus.UNAUTHORIZED);
        } else {
            return ResponseEntity.ok(criptoSeguidaService.agregarCriptoSeguida(criptoSeguidaRequest).representation());
        }

    }

}
