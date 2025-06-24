package com.example.trabajoClases.Model.Services;

import com.example.trabajoClases.Model.Dao.PersonaRepository;
import com.example.trabajoClases.Model.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    public Persona findByDni(String dni) {
        return personaRepository.findByDni(dni);
    }

    public List<Persona> findByNombreOrApellido(String nombre, String apellido) {
        return personaRepository.findByNombreOrApellido(nombre, apellido);
    }
}
