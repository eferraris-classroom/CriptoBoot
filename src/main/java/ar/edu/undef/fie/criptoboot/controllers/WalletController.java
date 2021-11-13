package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.entities.Wallet;
import ar.edu.undef.fie.criptoboot.services.WalletService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @RequestMapping(value = "usuarios/{idUser}/wallet")
    public Wallet getWallet(@PathVariable int idUser) {
        return walletService.getWallet(idUser);
    }

    @RequestMapping(value = "usuarios/{idUser}/wallet", method = RequestMethod.PATCH)
    public void cargarDisponible(@RequestBody Wallet wallet) {
        walletService.cargarDisponible(wallet);
    }

}
