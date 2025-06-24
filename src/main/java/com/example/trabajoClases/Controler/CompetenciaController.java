package com.example.trabajoClases.Controler;

import com.example.trabajoClases.Model.Entity.Competencia;
import com.example.trabajoClases.Model.Services.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
@CrossOrigin(origins = "*")
public class CompetenciaController {

    @Autowired
    private CompetenciaService competenciaService;

    @GetMapping
    public ResponseEntity<List<Competencia>> getAllCompetencias() {
        return ResponseEntity.ok(competenciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> getCompetenciaById(@PathVariable Long id) {
        return competenciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Competencia> createCompetencia(@RequestBody Competencia competencia) {
        return ResponseEntity.ok(competenciaService.save(competencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competencia> updateCompetencia(@PathVariable Long id, @RequestBody Competencia competencia) {
        return competenciaService.findById(id)
                .map(existing -> {
                    competencia.setIdCompetencia(id); // Asegúrate de tener este setter
                    return ResponseEntity.ok(competenciaService.save(competencia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetencia(@PathVariable Long id) {
        if (competenciaService.findById(id).isPresent()) {
            competenciaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Competencia>> buscarPorNombre(@RequestParam("nombre") String nombre) {
        return ResponseEntity.ok(competenciaService.buscarPorNombre(nombre));
    }

    @GetMapping("/{id}/contiene")
    public ResponseEntity<Boolean> contieneAccion(
            @PathVariable Long id,
            @RequestParam("accion") String accion
    ) {
        boolean contiene = competenciaService.contieneAccion(id, accion);
        return ResponseEntity.ok(contiene);
    }
}
