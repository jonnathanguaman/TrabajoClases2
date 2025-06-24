package com.example.trabajoClases.Controler;

import com.example.trabajoClases.Model.Entity.Persona;
import com.example.trabajoClases.Model.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = "*") // Puedes ajustar esto para seguridad CORS
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAll() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable Long id) {
        return personaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.save(persona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona persona) {
        return personaService.findById(id)
                .map(p -> {
                    persona.setIdPersona(id); // asegúrate de tener este setter
                    return ResponseEntity.ok(personaService.save(persona));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (personaService.findById(id).isPresent()) {
            personaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar/dni/{dni}")
    public ResponseEntity<Persona> getByDni(@PathVariable String dni) {
        Persona persona = personaService.findByDni(dni);
        return persona != null ? ResponseEntity.ok(persona) : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Persona>> getByNombreOrApellido(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido
    ) {
        return ResponseEntity.ok(personaService.findByNombreOrApellido(nombre, apellido));
    }
}
