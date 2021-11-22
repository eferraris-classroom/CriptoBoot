package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Usuario;
import ar.edu.undef.fie.criptoboot.entities.Wallet;
import ar.edu.undef.fie.criptoboot.repositories.WalletRepository;
import ar.edu.undef.fie.criptoboot.requests.WalletRequest;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    @Override
    public Wallet getWallet(int idUser) {
        return walletRepository.findByUsuarioId(idUser);
    }

    @Override
    public void crearWallet(Usuario usuario) {
        Wallet walletNueva= new Wallet();
        walletNueva.setUsuario(usuario);
        walletNueva.setDisponible(0);
        walletNueva.setBalance(0);
        walletNueva.setDivisiones_disponible(0);
        walletRepository.save(walletNueva);
    }

    @Override
    public Wallet modificarWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }


}
