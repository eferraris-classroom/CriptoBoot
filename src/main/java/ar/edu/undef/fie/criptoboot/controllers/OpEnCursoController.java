package ar.edu.undef.fie.criptoboot.controllers;


import ar.edu.undef.fie.criptoboot.entities.OpEnCurso;
import ar.edu.undef.fie.criptoboot.representations.OpEnCursoRepresentation;
import ar.edu.undef.fie.criptoboot.services.OpEnCursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OpEnCursoController {

    private final OpEnCursoService opEnCursoService;


    public OpEnCursoController(OpEnCursoService opEnCursoService) {
        this.opEnCursoService = opEnCursoService;
    }

    @GetMapping(value = "usuarios/{idUser}/OpEnCurso")
    public ResponseEntity<List<OpEnCursoRepresentation>> getOperaciones(@PathVariable int idUser) {
        return ResponseEntity.ok(opEnCursoService.getOperaciones(idUser)
                .stream()
                .map(OpEnCurso::representation).
                collect(Collectors.toList()));
    }

    @GetMapping(value = "usuarios/{idUser}/OpEnCursoActivas")
    public ResponseEntity<List<OpEnCursoRepresentation>> getOperacionesActivas(@PathVariable int idUser) {
        return ResponseEntity.ok(opEnCursoService.getOperacionesActivas(idUser)
                .stream()
                .map(OpEnCurso::representation).
                collect(Collectors.toList()));
    }

}
