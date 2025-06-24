package com.example.trabajoClases.Model.Services;

import com.example.trabajoClases.Model.Dao.TipoPagoRepository;
import com.example.trabajoClases.Model.Entity.TipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPagoService {

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    public List<TipoPago> findAll() {
        return tipoPagoRepository.findAll();
    }

    public Optional<TipoPago> findById(Long id) {
        return tipoPagoRepository.findById(id);
    }

    public TipoPago save(TipoPago tipoPago) {
        return tipoPagoRepository.save(tipoPago);
    }

    public void deleteById(Long id) {
        tipoPagoRepository.deleteById(id);
    }
}
