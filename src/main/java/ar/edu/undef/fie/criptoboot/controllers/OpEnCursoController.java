package ar.edu.undef.fie.criptoboot.controllers;


import ar.edu.undef.fie.criptoboot.entities.OpEnCurso;
import ar.edu.undef.fie.criptoboot.representations.OpEnCursoRepresentation;
import ar.edu.undef.fie.criptoboot.services.OpEnCursoService;
import ar.edu.undef.fie.criptoboot.services.SesionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OpEnCursoController {

    private final OpEnCursoService opEnCursoService;
    private final SesionService sesionService;


    public OpEnCursoController(OpEnCursoService opEnCursoService, SesionService sesionService) {
        this.opEnCursoService = opEnCursoService;
        this.sesionService = sesionService;
    }

    @GetMapping(value = "usuarios/{idUser}/OpEnCurso")
    public ResponseEntity<List<OpEnCursoRepresentation>> getOperaciones(@RequestHeader(value="Authorization") String token, @PathVariable int idUser) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<List<OpEnCursoRepresentation>>(HttpStatus.UNAUTHORIZED);
        } else {
            return ResponseEntity.ok(opEnCursoService.getOperaciones(idUser)
                    .stream()
                    .map(OpEnCurso::representation).
                    collect(Collectors.toList()));
        }
    }

    @GetMapping(value = "usuarios/{idUser}/OpEnCursoActivas")
    public ResponseEntity<List<OpEnCursoRepresentation>> getOperacionesActivas(@RequestHeader(value="Authorization") String token,@PathVariable int idUser) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<List<OpEnCursoRepresentation>>(HttpStatus.UNAUTHORIZED);
        } else {
            return ResponseEntity.ok(opEnCursoService.getOperacionesActivas(idUser)
                    .stream()
                    .map(OpEnCurso::representation).
                    collect(Collectors.toList()));
        }
    }

}
