package ar.edu.undef.fie.criptoboot.services;

import ar.edu.undef.fie.criptoboot.entities.Criptomoneda;
import ar.edu.undef.fie.criptoboot.repositories.CriptomonedaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriptomonedaServiceImpl implements CriptomonedaService{

    private final CriptomonedaRepository criptomonedaRepository;

    public CriptomonedaServiceImpl(CriptomonedaRepository criptomonedaRepository) {
        this.criptomonedaRepository = criptomonedaRepository;
    }

    @Override
    public List<Criptomoneda> getCriptomonedas(int userId) {
        //Cómo busco segun una clave foránea
        return criptomonedaRepository.findAll();
    }

    @Override
    public void cargarCripto(Criptomoneda criptomoneda) {
        criptomonedaRepository.save(criptomoneda);
    }

    @Override
    public Criptomoneda getCriptomonedasPorId(String id) {
        //return criptomonedaRepository.findById(id).get();
        //Como debería usar el método ya que mi id de las criptomonedas es un string
        return null;
    }

}
