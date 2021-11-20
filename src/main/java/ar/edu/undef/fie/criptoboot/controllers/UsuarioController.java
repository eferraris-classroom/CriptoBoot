package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Usuario;
import ar.edu.undef.fie.criptoboot.representations.ParametroRepresentation;
import ar.edu.undef.fie.criptoboot.representations.UsuarioRepresentation;
import ar.edu.undef.fie.criptoboot.requests.UsuarioRequest;
import ar.edu.undef.fie.criptoboot.services.UsuarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "usuarios/{idUser}")
    public ResponseEntity<UsuarioRepresentation> getUsuario(@PathVariable int idUser) {
        return ResponseEntity.ok(usuarioService.getUsuario(idUser).representation());
    }

    @PostMapping(value = "usuarios")
    public ResponseEntity<UsuarioRepresentation> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(usuarioService.registrar(usuarioRequest.construct()).representation());
    }


    @DeleteMapping(value = "usuarios/{idUser}")
    public  ResponseEntity<String> eliminarUsuario(@PathVariable int idUser) throws NotFoundException {
        usuarioService.eliminar(idUser);
        return new ResponseEntity<>(
                "Usuario eliminado con éxito",
                HttpStatus.OK);
    }
}
