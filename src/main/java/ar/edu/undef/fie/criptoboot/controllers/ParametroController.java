package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.OpEnCurso;
import ar.edu.undef.fie.criptoboot.entities.Parametro;
import ar.edu.undef.fie.criptoboot.representations.OpEnCursoRepresentation;
import ar.edu.undef.fie.criptoboot.representations.ParametroRepresentation;
import ar.edu.undef.fie.criptoboot.requests.ParametroRequest;
import ar.edu.undef.fie.criptoboot.services.ParametroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ParametroController {

    private final ParametroService parametroService;

    public ParametroController(ParametroService parametroService) {
        this.parametroService = parametroService;
    }

    @GetMapping(value = "usuarios/{idUser}/parametros")
    public ResponseEntity<ParametroRepresentation> getParametros(@PathVariable int idUser) {
        return ResponseEntity.ok(parametroService.getParametros(idUser).representation());
    }

    @PutMapping(value = "parametros")
    public ResponseEntity<ParametroRepresentation>  modificarParametros(@RequestBody ParametroRequest parametroRequest) {
        return ResponseEntity.ok(parametroService.modificarParametros(parametroRequest.construct()).representation());

    }
}
