package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.OpEnCurso;
import ar.edu.undef.fie.criptoboot.services.OpEnCursoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpEnCursoController {

    private final OpEnCursoService opEnCursoService;


    public OpEnCursoController(OpEnCursoService opEnCursoService) {
        this.opEnCursoService = opEnCursoService;
    }

    @RequestMapping(value = "usuarios/{idUser}/OpEnCurso")
    public List<OpEnCurso> getOperaciones(@PathVariable int idUser) {
        return opEnCursoService.getOperaciones(idUser);
    }

    @RequestMapping(value = "usuarios/{idUser}/OpEnCursoActivas")
    public List<OpEnCurso> getOperacionesActivas(@PathVariable int idUser) {
        return opEnCursoService.getOperacionesActivas(idUser);
    }
}
