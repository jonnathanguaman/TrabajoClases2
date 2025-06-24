package com.example.trabajoClases.Controler;

import com.example.trabajoClases.Model.Entity.TipoPago;
import com.example.trabajoClases.Model.Services.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-pago")
@CrossOrigin(origins = "*")
public class TipoPagoController {

    @Autowired
    private TipoPagoService tipoPagoService;

    @GetMapping
    public ResponseEntity<List<TipoPago>> getAllTiposPago() {
        return new ResponseEntity<>(tipoPagoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPago> getTipoPagoById(@PathVariable Long id) {
        Optional<TipoPago> tipoPago = tipoPagoService.findById(id);
        return tipoPago.map(tp -> new ResponseEntity<>(tp, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoPago> createTipoPago(@RequestBody TipoPago tipoPago) {
        try {
            return new ResponseEntity<>(tipoPagoService.save(tipoPago), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPago> updateTipoPago(@PathVariable Long id, @RequestBody TipoPago tipoPago) {
        Optional<TipoPago> existente = tipoPagoService.findById(id);
        if (existente.isPresent()) {
            tipoPago.setIdTipoPago(id);
            return new ResponseEntity<>(tipoPagoService.save(tipoPago), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPago(@PathVariable Long id) {
        if (tipoPagoService.findById(id).isPresent()) {
            tipoPagoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
