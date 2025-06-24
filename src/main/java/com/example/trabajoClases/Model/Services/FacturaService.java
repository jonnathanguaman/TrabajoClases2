package com.example.trabajoClases.Model.Services;

import com.example.trabajoClases.Model.Dao.FacturaRepository;
import com.example.trabajoClases.Model.Entity.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> findById(Long id) {
        return facturaRepository.findById(id);
    }

    public Factura save(Factura factura) {
        // Calcular total automáticamente
        if (factura.getItems() != null) {
            double total = factura.getItems().stream()
                    .mapToDouble(item -> item.getSubtotal())
                    .sum();
            factura.setTotal(total - factura.getDescuento());
        }
        return facturaRepository.save(factura);
    }

    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }

    public List<Factura> findByPersonaDni(String dni) {
        return facturaRepository.findByPersonaDni(dni);
    }

    public List<Factura> findByFechaBetween(java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin) {
        return facturaRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}