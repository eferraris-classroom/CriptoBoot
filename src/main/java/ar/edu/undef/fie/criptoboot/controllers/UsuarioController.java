package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Usuario;
import ar.edu.undef.fie.criptoboot.representations.UsuarioRepresentation;
import ar.edu.undef.fie.criptoboot.requests.UsuarioRequest;
import ar.edu.undef.fie.criptoboot.services.*;
import ar.edu.undef.fie.criptoboot.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final WalletService walletService;
    private final ParametroService parametroService;
    private final CriptoSeguidaService criptoSeguidaService;
    private final SesionService sesionService;

    public UsuarioController(UsuarioService usuarioService, WalletService walletService, ParametroService parametroService, CriptoSeguidaService criptoSeguidaService, SesionService sesionService) {
        this.usuarioService = usuarioService;
        this.walletService = walletService;
        this.parametroService = parametroService;
        this.criptoSeguidaService = criptoSeguidaService;

        this.sesionService = sesionService;
    }

    @GetMapping(value = "usuarios/{email}")
    public ResponseEntity<UsuarioRepresentation> getUsuarioController(@RequestHeader(value="Authorization") String token,@PathVariable String email) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<UsuarioRepresentation>(HttpStatus.UNAUTHORIZED);
        }else{
            return ResponseEntity.ok(usuarioService.getUsuario(email).representation());
        }

    }

    @PostMapping(value = "usuarios")
    public ResponseEntity<UsuarioRepresentation> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuarioRequest.getPassword());
        usuarioRequest.setPassword(hash);

        Usuario usuario = usuarioRequest.construct();

        parametroService.crearParametros(usuario);
        walletService.crearWallet(usuario);
        criptoSeguidaService.criptoSeguidaInicial(usuario);

        return ResponseEntity.ok(usuarioService.registrar(usuario).representation());
    }


    @DeleteMapping(value = "usuarios/{idUser}")
    public  ResponseEntity<String> eliminarUsuario(@RequestHeader(value="Authorization") String token, @PathVariable int idUser)  {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }else{
            usuarioService.eliminar(idUser);
            return new ResponseEntity<>(
                    "Usuario eliminado con éxito",
                    HttpStatus.OK);
        }


    }
}
