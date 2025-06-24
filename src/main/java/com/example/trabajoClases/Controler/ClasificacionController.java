package com.example.trabajoClases.Controler;


import com.example.trabajoClases.Model.Entity.Clasificacion;
import com.example.trabajoClases.Model.Services.ClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clasificaciones")
@CrossOrigin(origins = "*")
public class ClasificacionController {

    @Autowired
    private ClasificacionService clasificacionService;

    @GetMapping
    public ResponseEntity<List<Clasificacion>> getAllClasificaciones() {
        return ResponseEntity.ok(clasificacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clasificacion> getClasificacionById(@PathVariable Long id) {
        return clasificacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clasificacion> createClasificacion(@RequestBody Clasificacion clasificacion) {
        return ResponseEntity.ok(clasificacionService.save(clasificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clasificacion> updateClasificacion(@PathVariable Long id, @RequestBody Clasificacion clasificacion) {
        return clasificacionService.findById(id)
                .map(existing -> {
                    clasificacion.setIdClasificacion(id); // asegúrate de tener este setter
                    return ResponseEntity.ok(clasificacionService.save(clasificacion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClasificacion(@PathVariable Long id) {
        if (clasificacionService.findById(id).isPresent()) {
            clasificacionService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
