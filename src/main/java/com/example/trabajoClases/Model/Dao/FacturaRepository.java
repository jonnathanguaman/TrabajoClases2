package com.example.trabajoClases.Model.Dao;

import com.example.trabajoClases.Model.Entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findByPersonaDni(String dni);
    List<Factura> findByFechaBetween(java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin);

    @Query("SELECT f FROM Factura f WHERE f.total >= :montoMinimo")
    List<Factura> findByTotalGreaterThanEqual(@Param("montoMinimo") Double montoMinimo);
}
