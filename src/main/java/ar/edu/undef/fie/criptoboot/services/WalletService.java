package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Wallet;

public interface WalletService {
    Wallet getWallet(int idUser);

    void modificarWallet(Wallet wallet);

    void cargarDisponible(Wallet wallet);
}
