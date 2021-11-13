package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Parametro;

public interface ParametroService {
    Parametro getParametros(int idUser);

    void modificarParametros(Parametro parametro);
}
