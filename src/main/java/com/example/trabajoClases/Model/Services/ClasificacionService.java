package com.example.trabajoClases.Model.Services;

import com.example.trabajoClases.Model.Dao.ClasificacionRepository;
import com.example.trabajoClases.Model.Entity.Clasificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasificacionService {

    private final ClasificacionRepository clasificacionRepository;

    @Autowired
    public ClasificacionService(ClasificacionRepository clasificacionRepository) {
        this.clasificacionRepository = clasificacionRepository;
    }

    public List<Clasificacion> findAll() {
        return clasificacionRepository.findAll();
    }

    public Optional<Clasificacion> findById(Long id) {
        return clasificacionRepository.findById(id);
    }

    public Clasificacion save(Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }

    public void deleteById(Long id) {
        clasificacionRepository.deleteById(id);
    }
}
