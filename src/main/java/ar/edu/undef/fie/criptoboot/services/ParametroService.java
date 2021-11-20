package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Parametro;
import ar.edu.undef.fie.criptoboot.requests.ParametroRequest;

public interface ParametroService {
    Parametro getParametros(int idUser);

    Parametro modificarParametros(Parametro parametroRequest);
}
