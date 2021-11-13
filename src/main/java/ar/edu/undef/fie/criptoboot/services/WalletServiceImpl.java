package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Wallet;
import ar.edu.undef.fie.criptoboot.repositories.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    @Override
    public Wallet getWallet(int idUser) {
        //Cómo obtengo una wallet segun la clave foránea
        return null;
    }

    @Override
    public void modificarWallet(Wallet wallet) {
        //Cómo modifico un campo
    }

    @Override
    public void cargarDisponible(Wallet wallet) {
        //Cómo modifico un campo
    }
}
