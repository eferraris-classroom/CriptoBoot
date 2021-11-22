package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Sesion;
import ar.edu.undef.fie.criptoboot.entities.Usuario;
import ar.edu.undef.fie.criptoboot.repositories.SesionRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class SesionServiceImpl implements SesionService{

    private final SesionRepository sesionRepository;

    public SesionServiceImpl(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    @Override
    public Sesion getSesionActiva() {
        return sesionRepository.findSesionByActiva(true);
    }

    @Override
    public void nuevaSesion(Usuario usuario) {
        cerrarSesion();
        Sesion sesionNueva = new Sesion();
        sesionNueva.setUsuario(usuario);
        sesionNueva.setInicioSesion(Calendar.getInstance());
        sesionNueva.setActiva(true);
        sesionRepository.save(sesionNueva);
    }

    @Override
    public void cerrarSesion() {
        Sesion sesionActiva = getSesionActiva();
        if (sesionActiva != null){
            sesionActiva.setActiva(false);
            sesionRepository.save(sesionActiva);
        }

    }

}
