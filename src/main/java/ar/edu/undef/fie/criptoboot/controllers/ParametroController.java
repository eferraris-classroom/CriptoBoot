package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.representations.ParametroRepresentation;
import ar.edu.undef.fie.criptoboot.requests.ParametroRequest;
import ar.edu.undef.fie.criptoboot.services.ParametroService;
import ar.edu.undef.fie.criptoboot.services.SesionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParametroController {

    private final ParametroService parametroService;
    private final SesionService sesionService;

    public ParametroController(ParametroService parametroService, SesionService sesionService) {
        this.parametroService = parametroService;
        this.sesionService = sesionService;
    }

    @GetMapping(value = "usuarios/{idUser}/parametros")
    public ResponseEntity<ParametroRepresentation> getParametros(@RequestHeader(value="Authorization") String token,@PathVariable int idUser) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<ParametroRepresentation>(HttpStatus.UNAUTHORIZED);
        } else {
            return ResponseEntity.ok(parametroService.getParametros(idUser).representation());
        }
    }

    @PutMapping(value = "parametros")
    public ResponseEntity<ParametroRepresentation>  modificarParametros(@RequestHeader(value="Authorization") String token, @RequestBody ParametroRequest parametroRequest) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<ParametroRepresentation>(HttpStatus.UNAUTHORIZED);
        } else {
            return ResponseEntity.ok(parametroService.modificarParametros(parametroRequest.construct()).representation());
        }
    }
}
