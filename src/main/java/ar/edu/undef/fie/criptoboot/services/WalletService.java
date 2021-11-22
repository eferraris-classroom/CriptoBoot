package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Usuario;
import ar.edu.undef.fie.criptoboot.entities.Wallet;
import ar.edu.undef.fie.criptoboot.requests.WalletRequest;

public interface WalletService {
    Wallet getWallet(int idUser);

    void crearWallet(Usuario usuario);

    Wallet modificarWallet(Wallet wallet);

}
