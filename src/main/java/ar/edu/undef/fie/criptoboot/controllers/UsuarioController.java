package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Usuario;
import ar.edu.undef.fie.criptoboot.representations.UsuarioRepresentation;
import ar.edu.undef.fie.criptoboot.requests.UsuarioRequest;
import ar.edu.undef.fie.criptoboot.services.CriptoSeguidaService;
import ar.edu.undef.fie.criptoboot.services.ParametroService;
import ar.edu.undef.fie.criptoboot.services.UsuarioService;
import ar.edu.undef.fie.criptoboot.services.WalletService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final WalletService walletService;
    private final ParametroService parametroService;
    private final CriptoSeguidaService criptoSeguidaService;

    public UsuarioController(UsuarioService usuarioService, WalletService walletService, ParametroService parametroService, CriptoSeguidaService criptoSeguidaService) {
        this.usuarioService = usuarioService;
        this.walletService = walletService;
        this.parametroService = parametroService;
        this.criptoSeguidaService = criptoSeguidaService;
    }

    @GetMapping(value = "usuarios/{email}")
    public ResponseEntity<UsuarioRepresentation> getUsuarioController(@PathVariable String email) {
        return ResponseEntity.ok(usuarioService.getUsuario(email).representation());
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
    public  ResponseEntity<String> eliminarUsuario(@PathVariable int idUser) throws NotFoundException {
        usuarioService.eliminar(idUser);
        return new ResponseEntity<>(
                "Usuario eliminado con éxito",
                HttpStatus.OK);
    }
}
