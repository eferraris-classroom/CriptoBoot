package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Wallet;
import ar.edu.undef.fie.criptoboot.representations.ParametroRepresentation;
import ar.edu.undef.fie.criptoboot.representations.WalletRepresentation;
import ar.edu.undef.fie.criptoboot.requests.ParametroRequest;
import ar.edu.undef.fie.criptoboot.requests.WalletRequest;
import ar.edu.undef.fie.criptoboot.services.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping(value = "usuarios/{idUser}/wallet")
    public ResponseEntity<WalletRepresentation> getWallet(@PathVariable int idUser) {
        return ResponseEntity.ok(walletService.getWallet(idUser).representation());
    }


    @PutMapping(value = "wallet")
    public ResponseEntity<WalletRepresentation> modificarParametrosWallet(@RequestBody WalletRequest walletRequest) {
        return ResponseEntity.ok(walletService.modificarWallet(walletRequest.construct()).representation());

    }

}
