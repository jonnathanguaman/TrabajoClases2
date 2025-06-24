package com.example.trabajoClases.Model.Dao;

import com.example.trabajoClases.Model.Entity.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Long> {
    TipoPago findByTipo(String tipo);
}