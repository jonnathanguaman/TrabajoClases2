package com.example.trabajoClases.Model.Services;

import com.example.trabajoClases.Model.Dao.CompetenciaRepository;
import com.example.trabajoClases.Model.Entity.Competencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;

    @Autowired
    public CompetenciaService(CompetenciaRepository competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }

    public List<Competencia> findAll() {
        return competenciaRepository.findAll();
    }

    public Optional<Competencia> findById(Long id) {
        return competenciaRepository.findById(id);
    }

    public Competencia save(Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    public void deleteById(Long id) {
        competenciaRepository.deleteById(id);
    }

    public List<Competencia> buscarPorNombre(String palabraClave) {
        return competenciaRepository.findByNombreContainingIgnoreCase(palabraClave);
    }

    public boolean contieneAccion(Long id, String accion) {
        return competenciaRepository.findById(id)
                .map(c -> c.sexoComp(accion))
                .orElse(false);
    }
}