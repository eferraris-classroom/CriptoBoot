package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Sesion;
import ar.edu.undef.fie.criptoboot.entities.Usuario;
import ar.edu.undef.fie.criptoboot.repositories.SesionRepository;
import ar.edu.undef.fie.criptoboot.utils.JWTUtil;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class SesionServiceImpl implements SesionService{

    private final SesionRepository sesionRepository;
    private final JWTUtil jwtUtil;

    public SesionServiceImpl(SesionRepository sesionRepository, JWTUtil jwtUtil) {
        this.sesionRepository = sesionRepository;
        this.jwtUtil = jwtUtil;
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
            sesionActiva.setFinSesion(Calendar.getInstance());
            sesionRepository.save(sesionActiva);
        }

    }

    @Override
    public boolean validarSesion(String token) {
            String usuarioId = jwtUtil.getKey(token);
            if (usuarioId == null){
                return false;
            }else{
                int idInt=Integer.parseInt(usuarioId);
                if (getSesionActiva().getUsuario().getId()==idInt) {
                    return true;
                }else return false;
            }
    }

}
