package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Usuario;
import ar.edu.undef.fie.criptoboot.requests.UsuarioRequest;
import ar.edu.undef.fie.criptoboot.services.SesionService;
import ar.edu.undef.fie.criptoboot.services.UsuarioService;
import ar.edu.undef.fie.criptoboot.utils.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UsuarioService usuarioService;
    private final JWTUtil jwtUtil;
    private final SesionService sesionService;

    public AuthController(UsuarioService usuarioService, JWTUtil jwtUtil, SesionService sesionService) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.sesionService = sesionService;
    }


    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody UsuarioRequest usuarioRequest) {

        Usuario usuarioLogueado = usuarioService.obtenerUsuarioPorCredenciales(usuarioRequest.construct());

        if (usuarioLogueado != null) {
            sesionService.nuevaSesion(usuarioLogueado);
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return ResponseEntity.ok(tokenJwt);
        }else {
            return new ResponseEntity<>(
                    "Error en la autenticación",
                    HttpStatus.BAD_REQUEST);
        }
    }






}
