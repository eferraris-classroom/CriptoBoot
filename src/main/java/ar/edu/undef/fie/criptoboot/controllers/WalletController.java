package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.representations.WalletRepresentation;
import ar.edu.undef.fie.criptoboot.requests.WalletRequest;
import ar.edu.undef.fie.criptoboot.services.SesionService;
import ar.edu.undef.fie.criptoboot.services.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    private final WalletService walletService;
    private final SesionService sesionService;

    public WalletController(WalletService walletService, SesionService sesionService) {
        this.walletService = walletService;
        this.sesionService = sesionService;
    }

    @GetMapping(value = "usuarios/{idUser}/wallet")
    public ResponseEntity<WalletRepresentation> getWallet(@RequestHeader(value="Authorization") String token,@PathVariable int idUser) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<WalletRepresentation>(HttpStatus.UNAUTHORIZED);
        } else {
            return ResponseEntity.ok(walletService.getWallet(idUser).representation());
        }
    }


    @PutMapping(value = "wallet")
    public ResponseEntity<WalletRepresentation> modificarParametrosWallet(@RequestHeader(value="Authorization") String token,@RequestBody WalletRequest walletRequest) {
        if (!sesionService.validarSesion(token)) {
            return new ResponseEntity<WalletRepresentation>(HttpStatus.UNAUTHORIZED);
        } else {
            return ResponseEntity.ok(walletService.modificarWallet(walletRequest.construct()).representation());
        }
    }

}
